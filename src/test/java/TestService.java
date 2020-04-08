import com.olehhilchenko.model.Developer;
import com.olehhilchenko.model.Skill;
import com.olehhilchenko.model.Specialty;
import com.olehhilchenko.repository.DeveloperRepository;
import com.olehhilchenko.repository.hibernate.DeveloperDAO;
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
        skillList.add(new Skill(444555, "mi"));
        skillList.add(new Skill(444556, "mimimi"));
        Specialty specialty = new Specialty(333555, "lol", "kek");
        developer = new Developer(111222, "Olegolas", "Gil", specialty, skillList);

        List<Skill> controlSkillList = new ArrayList<>();
        controlSkillList.add(new Skill(444555, "mi"));
        controlSkillList.add(new Skill(444556, "mimimi"));
        Specialty controlSpecialty = new Specialty(333555, "lol", "kek");
        controlDeveloper = new Developer(111222, "Olegolas", "Gil", controlSpecialty, controlSkillList);

        List<Skill> updatedSkillList = new ArrayList<>();
        updatedSkillList.add(new Skill(444555, "Fast"));
        updatedSkillList.add(new Skill(444556, "Smart"));
        Specialty updatedSpecialty = new Specialty(333555, "Java", "SE, EECore");
        updatedDeveloper = new Developer(111222, "Oleg", "Gilchenko", updatedSpecialty, updatedSkillList);
    }

    @Test
    public void DevDAOInsert() {
        DeveloperRepository developerRepository = new DeveloperDAO();
        developerRepository.insert(developer);
    }

    @Test
    public void SelDAO() {
        DeveloperRepository developerRepository = new DeveloperDAO();
        System.out.println(developerRepository.select(111222));
    }

    @Test
    public void UpdDAO() {
        DeveloperRepository developerRepository = new DeveloperDAO();
        developerRepository.update(updatedDeveloper);
    }


    @Test
    public void DelDAO() {
        DeveloperRepository developerRepository = new DeveloperDAO();
        developerRepository.delete(updatedDeveloper);
    }

    @Test
    public void GetListDAO() {
        DeveloperRepository developerRepository = new DeveloperDAO();
        List<Developer> developerList = ((DeveloperDAO) developerRepository).getDeveloperList();
        for (Developer developer : developerList)
            System.out.println(developer);
    }

    @Test
    public void getId() {
        /**
         * DeveloperService class method, returns the next free id from sql db(subsequently used to create a new object by the developer).
         * */
        System.out.println(developerService.nextId());
    }
}