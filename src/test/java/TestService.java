import com.olehhilchenko.model.Developer;
import com.olehhilchenko.model.Skill;
import com.olehhilchenko.model.Specialty;
import com.olehhilchenko.service.Service;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestService {
    /**
     * Test class for {@link com.olehhilchenko.service.Service}
     *
     * @author Oleg Gilchenko
     * @version 1.0
     */
    private static Service service = new Service();
    private static Developer developer;
    private static Developer controlDeveloper;
    private static Developer selectedDeveloper;
    private static Developer updatedDeveloper;

    @BeforeClass
    public static void setUp() {
        //Create a new Developer.
        List<Skill> skillList = new ArrayList<Skill>();
        skillList.add(new Skill(service.nextId(), "Funy"));
        skillList.add(new Skill(service.nextId(), "Smart"));
        developer = new Developer(service.nextId(), "Petro", "Golub", new Specialty(service.nextId(), "Java", "EE"), skillList);
        //Get controlDeveloper(By copying developer).
        controlDeveloper = getCopy(developer);

        updatedDeveloper = getCopy(developer);
        updatedDeveloper.setFirstName("Peter");
        updatedDeveloper.setLastName("Gol");
    }

    @Test
    public void getId() {
        /**
         * Service class method, returns the next free id from sql db(subsequently used to create a new object by the developer).
         * */
        System.out.println(service.nextId());
    }


    private static Developer getCopy(Developer d) {
        return new Developer(d.getId(), d.getFirstName(), d.getLastName(), new Specialty(d.getSpecialty().getId(), d.getSpecialty().getName(), d.getSpecialty().getDescription()), new ArrayList<Skill>(d.getSkills()));
    }

    @Test
    public void insertAndSelectDeveloper() {
        //Insert developer in to mySQL database.
        service.add(developer);
        //selectedDeveloper assign received Developer from mySQL data base.
        selectedDeveloper = service.get(controlDeveloper.getId());
        //Compare control and received Developers.
        assertEquals(controlDeveloper, selectedDeveloper);
        //Get developer before update.
        System.out.println(service.get(controlDeveloper.getId()));
        //Update developer.
        service.update(updatedDeveloper);
        //Get developer after update.
        System.out.println(service.get(controlDeveloper.getId()));
        //Delete developer frome mySQL database.
        service.remove(updatedDeveloper);

        assertEquals(new Developer(0, null, null, new Specialty(), new ArrayList<Skill>()), service.get(controlDeveloper.getId()));

    }
}
