package com.olehhilchenko.controller;

import com.olehhilchenko.model.Developer;
import com.olehhilchenko.model.Skill;
import com.olehhilchenko.service.Service;
import com.olehhilchenko.view.PrintPartOfTheMenu;

import java.util.ArrayList;
import java.util.List;

public class DeveloperController {
    private SpecialtyController specialtyController = new SpecialtyController();
    private SkillController skillController = new SkillController();
    private Service service = new Service();


    public void addDeveloper() {
        Developer developer = new Developer();

        developer.setId(service.nextId());

        System.out.println(PrintPartOfTheMenu.ENTER_FIRST_NAME);
        developer.setFirstName(PrintPartOfTheMenu.stringScanner());

        System.out.println(PrintPartOfTheMenu.ENTER_LAST_NAME);
        developer.setLastName(PrintPartOfTheMenu.stringScanner());

        developer.setSpecialty(specialtyController.newSpecialty());

        List<Skill> skillList = new ArrayList<Skill>();

        int addNewSkill = 1;

        do {
            skillList.add(skillController.newSkill());

            System.out.println(PrintPartOfTheMenu.ENTER_1_TO_ADD_NEXT_SKILL_OR_0_TO_SKIP_NEXT_SKILL);
            int nextStep = PrintPartOfTheMenu.integerScanner();

            if (nextStep != 1) {
                addNewSkill = 0;
            }

        } while (0 != addNewSkill);

        developer.setSkills(skillList);

        System.out.println(developer);

        service.add(developer);
    }

    public void viewDeveloper() {
        System.out.println(PrintPartOfTheMenu.ENTER_THE_ID_OF_THE_DEVELOPER_WHOSE_DATA_YOU_WANT_TO_SEE);
        int id = PrintPartOfTheMenu.integerScanner();

        System.out.println(service.get(id));

    }

    public void removeDeveloper() {
        System.out.println(PrintPartOfTheMenu.ENTER_THE_ID_OF_THE_DEVELOPER_WHOSE_DATA_YOU_WANT_TO_DELETE);
        int id = PrintPartOfTheMenu.integerScanner();

        Developer developer = service.get(id);

        service.remove(developer);

    }

    public void updateDeveloper() {
        System.out.println(PrintPartOfTheMenu.ENTER_THE_ID_OF_THE_DEVELOPER_WHOSE_DATA_YOU_WANT_TO_UPDATE);
        int id = PrintPartOfTheMenu.integerScanner();

        Developer updatedDeveloper = service.get(id);

        System.out.println(updatedDeveloper.getFirstName());
        System.out.println(PrintPartOfTheMenu.ENTER_UPDATED_FIRST_NAME);
        updatedDeveloper.setFirstName(PrintPartOfTheMenu.stringScanner());

        System.out.println(updatedDeveloper.getLastName());
        System.out.println(PrintPartOfTheMenu.ENTER_UPDATED_LAST_NAME);
        updatedDeveloper.setLastName(PrintPartOfTheMenu.stringScanner());

        updatedDeveloper.setSpecialty(specialtyController.updateSpecialty(updatedDeveloper.getSpecialty()));

        List<Skill> updatedSkillList = new ArrayList<Skill>();

        for (Skill skill : updatedDeveloper.getSkills()) {

            updatedSkillList.add(skillController.updateSkill(skill));
        }

        updatedDeveloper.setSkills(updatedSkillList);

        System.out.println(updatedDeveloper);

        service.update(updatedDeveloper);
    }
}
