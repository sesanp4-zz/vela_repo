package contactapi.demo;

import contactapi.demo.Entities.Developer;
import contactapi.demo.Repo.Dao;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DaoTest {

   static Dao dao;
   static Developer dev1;
  static   Developer dev2;

    @BeforeClass
    public static void setUp() throws Exception{
        dao = mock(Dao.class);
        dev1 = new Developer();
        dev2 = new Developer();

        dev1.setAddress("kilo");
        dev1.setDate_added("2019/02/09");
        dev1.setMobile("09090");
        dev1.setName("ssp ssp");
        dev1.setRole("full stack");
        dev1.setNick("major");
        dev1.setId(1L);


        dev2.setAddress("aguda");
        dev2.setDate_added("2019/02/09");
        dev2.setMobile("07070");
        dev2.setName("ppp ppp");
        dev2.setRole("front-end");
        dev2.setNick("minor");
        dev2.setId(2L);

        when(dao.findall()).thenReturn(Arrays.asList(dev1,dev2));
        when(dao.findByNick("major")).thenReturn(dev1);
        when(dao.addDeveloper(dev1)).thenReturn(dev1);
        when(dao.update(1L,dev1)).thenReturn(dev1);

    }

    @Test
    public void testGetAllDevelopers() throws Exception{
      Iterable<Developer> developers = dao.findall();
      List<Developer>developerList = new ArrayList<>();
      developers.forEach(developerList::add);
      assertEquals(2,developerList.size());
      Developer developer = developerList.get(0);
      assertEquals("major",developer.getNick());
    }

   @Test
    public void testGetDeveloper() throws Exception{

        String nick ="major";
       Developer developer = dao.findByNick(nick);
        assertEquals("09090",developer.getMobile());

    }

    @Test
    public void testAddDeveloper() throws Exception{
       Developer developer = dao.addDeveloper(dev1);
       assertNotNull(developer);
    }

    @Test
    public void updateDeveloper() throws Exception{
      Developer developer = dao.update(1L,dev1);
      assertNotNull(developer);
      assertEquals(dev1,developer);
    }

}
