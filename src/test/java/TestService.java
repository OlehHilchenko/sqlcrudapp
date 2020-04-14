import com.olehhilchenko.model.Developer;
import com.olehhilchenko.model.Skill;
import com.olehhilchenko.model.Specialty;
import com.olehhilchenko.repository.hibernate.HibernateUtil;
import com.olehhilchenko.service.DeveloperService;
import org.hibernate.ObjectNotFoundException;
import org.junit.After;
import org.junit.Test;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class TestService {

    /**
     * Test class for {@link DeveloperService}
     *
     * @author Oleg Gilchenko
     * @version 1.0
     */

    private DeveloperService developerService = new DeveloperService();

    @After
    public void tearDown() {
        try (Statement statement = HibernateUtil.connection().createStatement()) {
            statement.addBatch("TRUNCATE TABLE developer;");
            statement.addBatch("TRUNCATE TABLE developer_specialty;");
            statement.addBatch("TRUNCATE TABLE developer_skills;");
            statement.addBatch("TRUNCATE TABLE specialty;");
            statement.addBatch("TRUNCATE TABLE skills;");
            statement.executeBatch();
        } catch (ClassNotFoundException cx) {
            cx.printStackTrace();
        } catch (SQLException sx) {
            sx.printStackTrace();
        }
    }

    @Test
    public void insertAndSelectUseDeveloperService() {
        List<Skill> skillList = new ArrayList<>();
        skillList.add(new Skill(444555, "testSkill01"));
        skillList.add(new Skill(444556, "testSkill02"));
        Specialty specialty = new Specialty(333555, "testSpecialty01", "testDescription");
        Developer testDeveloperOne = new Developer(111222, "testDeveloper01", "testDeveloper01", specialty, skillList);

        developerService.add(testDeveloperOne);
        Developer getDeveloper = developerService.get(111222);
        assertNotNull(getDeveloper);
        assertTrue(testDeveloperOne.getId() == getDeveloper.getId());
    }

    @Test
    public void updateAndDeleteUseDeveloperService() {
        List<Skill> skillList = new ArrayList<>();
        skillList.add(new Skill(334, "newTestSkill01"));
        skillList.add(new Skill(333, "newTestSkill02"));
        Specialty specialty = new Specialty(223, "newTestSpecialty", "newTestDescription");
        Developer testDeveloperTwo = new Developer(123, "testFirstName", "testLastName", specialty, skillList);

        developerService.add(testDeveloperTwo);
        testDeveloperTwo.setFirstName("testDev");
        testDeveloperTwo.setLastName("testDev");

        developerService.update(testDeveloperTwo);
        Developer getDeveloper = developerService.get(123);
        assertTrue("testDev".equals(getDeveloper.getFirstName()) && "testDev".equals(getDeveloper.getLastName()));
        developerService.remove(getDeveloper);

        assertThrows(ObjectNotFoundException.class, () -> {
            developerService.get(123);
        });
    }

    @Test
    public void getId() {
        //DeveloperService class method, returns the next free id from sql db(subsequently used to create a new object by the developer).
        int id = developerService.nextId();
        System.out.println(id);
        assertTrue(id > 0);
    }
}