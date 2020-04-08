package com.olehhilchenko.controller;

import com.olehhilchenko.model.Developer;
import com.olehhilchenko.model.Skill;
import com.olehhilchenko.model.Specialty;
import com.olehhilchenko.service.DeveloperService;
import com.olehhilchenko.view.PrintPartOfTheMenu;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private DeveloperService developerService = new DeveloperService();


    public void addDeveloper() {
        Developer developer = new Developer();

        developer.setId(developerService.nextId());

        System.out.println(PrintPartOfTheMenu.ENTER_FIRST_NAME);
        developer.setFirstName(PrintPartOfTheMenu.stringScanner());

        System.out.println(PrintPartOfTheMenu.ENTER_LAST_NAME);
        developer.setLastName(PrintPartOfTheMenu.stringScanner());

        Specialty specialty = new Specialty();

        specialty.setId(developerService.nextId());

        System.out.println(PrintPartOfTheMenu.ENTER_SPECIALTY_NAME);
        specialty.setName(PrintPartOfTheMenu.stringScanner());

        System.out.println(PrintPartOfTheMenu.ENTER_SPECIALTY_DESCRIPTION);
        specialty.setDescription(PrintPartOfTheMenu.stringScanner());

        developer.setSpecialty(specialty);

        List<Skill> skillList = new ArrayList<Skill>();

        int addNewSkill = 1;

        do {
            System.out.println(PrintPartOfTheMenu.ENTER_SKILL_NAME);
            skillList.add(new Skill(developerService.nextId(), PrintPartOfTheMenu.stringScanner()));

            System.out.println(PrintPartOfTheMenu.ENTER_1_TO_ADD_NEXT_SKILL_OR_0_TO_SKIP_NEXT_SKILL);
            int nextStep = PrintPartOfTheMenu.integerScanner();

            if (nextStep != 1) {
                addNewSkill = 0;
            }

        } while (0 != addNewSkill);

        developer.setSkills(skillList);

        System.out.println(developer);

        developerService.add(developer);

    }

    public void viewDeveloper() {
        System.out.println(PrintPartOfTheMenu.ENTER_THE_ID_OF_THE_DEVELOPER_WHOSE_DATA_YOU_WANT_TO_SEE);
        int id = PrintPartOfTheMenu.integerScanner();

        Developer developer = developerService.get(id);
        System.out.println(developer);
    }

    public void removeDeveloper() {
        System.out.println(PrintPartOfTheMenu.ENTER_THE_ID_OF_THE_DEVELOPER_WHOSE_DATA_YOU_WANT_TO_DELETE);
        int id = PrintPartOfTheMenu.integerScanner();

        Developer developer = developerService.get(id);
        developerService.remove(developer);
    }

    public void updateDeveloper() {
        System.out.println(PrintPartOfTheMenu.ENTER_THE_ID_OF_THE_DEVELOPER_WHOSE_DATA_YOU_WANT_TO_UPDATE);
        int id = PrintPartOfTheMenu.integerScanner();

        Developer updatedDeveloper = developerService.get(id);

        System.out.println(updatedDeveloper.getFirstName());
        System.out.println(PrintPartOfTheMenu.ENTER_UPDATED_FIRST_NAME);
        updatedDeveloper.setFirstName(PrintPartOfTheMenu.stringScanner());

        System.out.println(updatedDeveloper.getLastName());
        System.out.println(PrintPartOfTheMenu.ENTER_UPDATED_LAST_NAME);
        updatedDeveloper.setLastName(PrintPartOfTheMenu.stringScanner());

        Specialty updatedSpecialty = updatedDeveloper.getSpecialty();
        System.out.println(updatedSpecialty.getName());
        System.out.println(PrintPartOfTheMenu.ENTER_UPDATED_SPECIALTY_NAME);
        updatedSpecialty.setName(PrintPartOfTheMenu.stringScanner());

        System.out.println(updatedSpecialty.getDescription());
        System.out.println(PrintPartOfTheMenu.ENTER_UPDATED_SPECIALTY_DESCRIPTION);
        updatedSpecialty.setDescription(PrintPartOfTheMenu.stringScanner());
        updatedDeveloper.setSpecialty(updatedSpecialty);

        List<Skill> updatedSkillList = new ArrayList<Skill>();

        for (Skill skill : updatedDeveloper.getSkills()) {
            Skill updatedSkill = skill;
            System.out.println(updatedSkill.getName());
            System.out.println(PrintPartOfTheMenu.ENTER_UPDATED_SKILL_NAME);
            updatedSkill.setName(PrintPartOfTheMenu.stringScanner());
            updatedSkillList.add(updatedSkill);
        }

        updatedDeveloper.setSkills(updatedSkillList);
        developerService.update(updatedDeveloper);
    }

    public void viewAllDeveloper() {
        System.out.println();
        for (Developer developer : developerService.getDeveloperList())
            System.out.println(developer);
        System.out.println();
    }
}
