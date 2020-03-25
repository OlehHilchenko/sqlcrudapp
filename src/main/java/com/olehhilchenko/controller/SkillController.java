package com.olehhilchenko.controller;

import com.olehhilchenko.model.Skill;
import com.olehhilchenko.service.Service;
import com.olehhilchenko.view.PrintPartOfTheMenu;

public class SkillController {
    private Service service = new Service();

    public Skill newSkill() {

        System.out.println(PrintPartOfTheMenu.ENTER_SKILL_NAME);
        return new Skill(service.nextId(), PrintPartOfTheMenu.stringScanner());
    }

    public Skill updateSkill(Skill updatedSkill) {

        System.out.println(updatedSkill.getName());
        System.out.println(PrintPartOfTheMenu.ENTER_UPDATED_SKILL_NAME);
        updatedSkill.setName(PrintPartOfTheMenu.stringScanner());
        return updatedSkill;
    }
}
