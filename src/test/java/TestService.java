import com.olehhilchenko.model.Developer;
import com.olehhilchenko.model.Skill;
import com.olehhilchenko.model.Specialty;
import com.olehhilchenko.service.DeveloperService;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestService {
    /**
     * Test class for {@link DeveloperService}
     *
     * @author Oleg Gilchenko
     * @version 1.0
     */


    private static DeveloperService developerService = new DeveloperService();

    private static Developer developer;
    private static Developer controlDeveloper;
    private static Developer selectedDeveloper;
    private static Developer updatedDeveloper;

    @BeforeClass
    public static void setUp() {
        List<Skill> skillList = new ArrayList<>();
        skillList.add(new Skill(444555, null));
        skillList.add(new Skill(444556, null));
        Specialty specialty = new Specialty(333555, null, null);
        developer = new Developer(111222, "Olegolas", "Gil", specialty, skillList);

        List<Skill> controlSkillList = new ArrayList<>();
        controlSkillList.add(new Skill(444555, null));
        controlSkillList.add(new Skill(444556, null));
        Specialty controlSpecialty = new Specialty(333555, null, null);
        controlDeveloper = new Developer(111222, "Olegolas", "Gil", controlSpecialty, controlSkillList);

        updatedDeveloper = new Developer(111222, "Oleg", "Gilchenko", null, null);
    }

    @Test
    public void getId() {
        /**
         * DeveloperService class method, returns the next free id from sql db(subsequently used to create a new object by the developer).
         * */
        System.out.println(developerService.nextId());
    }


    @Test
    public void insert() {
        developerService.add(developer);
    }

    @Test
    public void select() {
        selectedDeveloper = developerService.get(111222);
        System.out.println(controlDeveloper);
        System.out.println(selectedDeveloper);
        assertEquals(controlDeveloper, selectedDeveloper);
    }

    @Test
    public void update() {
        System.out.println(developerService.get(111222));
        developerService.update(updatedDeveloper);
        System.out.println(developerService.get(111222));
    }

    @Test
    public void delete() {
        System.out.println(developerService.get(111222));
        developerService.remove(updatedDeveloper);
        System.out.println(developerService.get(111222));
    }
}
