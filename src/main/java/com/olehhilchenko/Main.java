package com.olehhilchenko;

import com.olehhilchenko.model.Skill;
import com.olehhilchenko.model.Specialty;
import com.olehhilchenko.repository.SkillRepositoryImplementation;
import com.olehhilchenko.repository.SpecialtyRepositoryImplementation;
import com.olehhilchenko.repository.conection.SkillConnection;


public class Main {

    public static void main(String[] args) {
	// write your code here

        Skill skill = new Skill(5, "Smart");
        SkillRepositoryImplementation skillRepositoryImplementation = new SkillRepositoryImplementation();

        //skillRepositoryImplementation.insert(new Skill(2, "ExtraSmart"));

        //System.out.println(skillRepositoryImplementation.selectSkillList(2));

        //skillRepositoryImplementation.delete(new Skill(2, "ExtraSmart"));

        //skillRepositoryImplementation.update(new Skill(5, "ExtraSmart"), "Smart");
        Specialty specialty = new Specialty(11, "c++", "core");
        SpecialtyRepositoryImplementation specialtyRepositoryImplementation = new SpecialtyRepositoryImplementation();

        //specialtyRepositoryImplementation.insert(specialty);

        //specialtyRepositoryImplementation.delete(specialty);

        //System.out.println(specialtyRepositoryImplementation.select(2));

        //specialtyRepositoryImplementation.update(specialty);
    }
}
