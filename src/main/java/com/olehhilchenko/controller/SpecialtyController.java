package com.olehhilchenko.controller;

import com.olehhilchenko.model.Specialty;
import com.olehhilchenko.service.Service;
import com.olehhilchenko.view.PrintPartOfTheMenu;

public class SpecialtyController {
    private Service service = new Service();

    public Specialty newSpecialty() {

        Specialty specialty = new Specialty();

        specialty.setId(service.nextId());

        System.out.println(PrintPartOfTheMenu.ENTER_SPECIALTY_NAME);
        specialty.setName(PrintPartOfTheMenu.stringScanner());

        System.out.println(PrintPartOfTheMenu.ENTER_SPECIALTY_DESCRIPTION);
        specialty.setDescription(PrintPartOfTheMenu.stringScanner());

        return specialty;
    }

    public Specialty updateSpecialty(Specialty updatedSpecialty) {

        System.out.println(updatedSpecialty.getName());
        System.out.println(PrintPartOfTheMenu.ENTER_UPDATED_SPECIALTY_NAME);
        updatedSpecialty.setName(PrintPartOfTheMenu.stringScanner());

        System.out.println(updatedSpecialty.getDescription());
        System.out.println(PrintPartOfTheMenu.ENTER_UPDATED_SPECIALTY_DESCRIPTION);
        updatedSpecialty.setDescription(PrintPartOfTheMenu.stringScanner());

        return updatedSpecialty;
    }
}
