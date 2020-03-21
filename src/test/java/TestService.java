import com.olehhilchenko.model.Developer;
import com.olehhilchenko.model.Skill;
import com.olehhilchenko.model.Specialty;
import com.olehhilchenko.service.Service;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestService {
    /**
     * Test class for {@link com.olehhilchenko.service.Service}
     *
     * @author Oleg Gilchenko
     * @version 1.0
     */
    private Service service = new Service();

    @Test
    public void getFiveId (){
        for(int i = 0; i < 5; i++){
            System.out.println(service.nextId());
        }
    }


    @Test
    public void insertDeveloper(){
        List<Skill> skillList = new ArrayList<Skill>();
        skillList.add(new Skill(service.nextId(), "Funy"));
        skillList.add(new Skill(service.nextId(), "Smart"));
        Developer developer = new Developer(service.nextId(), "Petro", "Golub", new Specialty(service.nextId(), "Java", "EE"), skillList);
        service.add(developer);
    }

    @Test
    public void selectDeveloper(){
        System.out.println(service.get(37));
    }

    @Test
    public void deleteDeveloper(){

        List<Skill> skillList = new ArrayList<Skill>();
        skillList.add(new Skill(33, "Fast"));
        skillList.add(new Skill(34, "ExtraSmart"));
        Specialty specialty1 = new Specialty(22, "C++", "core");
        Developer developer = new Developer(11, "Oleg", "Gil", specialty1, skillList);
        service.remove(developer);
    }

    @Test
    public void updateDeveloper(){
        List<Skill> skillList = new ArrayList<Skill>();
        skillList.add(new Skill(35, "Fast"));
        skillList.add(new Skill(36, "ExtraSmart"));
        Developer developer = new Developer(37, "Oleg", "Gilchenko", new Specialty(38, "Java", "SE"), skillList);
        service.update(developer);
    }
}
