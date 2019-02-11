package contactapi.demo.Repo;

import contactapi.demo.Entities.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Dao {

    @Autowired
    DeveloperRespository d_repo;

    //   @Autowired
    // AdminRepo a_repo;

    public Developer addDeveloper(Developer developer){
        return d_repo.save(developer);
    }


    public Developer findByNick(String nick){
       return findByNick(nick);
    }



    public Iterable<Developer> findall(){
        return d_repo.findAll();
    }


    public Developer findone(Long id){
        Developer d=d_repo.findById(id).get();
        System.out.println(d.getName());
        System.out.println(d.getAddress());
        System.out.println(d.getDate_added());
        System.out.println(d.getMobile());
        System.out.println(d.getRole());
        return d;
    }

    public boolean Delete(Long id){
        Developer developer = d_repo.findById(id).get();
        d_repo.delete(developer);
        return true;
    }

    public Developer update(Long id, Developer developer){;
        Developer dev = d_repo.findById(id).get();
        dev.setAddress(developer.getAddress());
        dev.setMobile(developer.getMobile());
        dev.setName(developer.getName());
        dev.setRole(developer.getRole());
        dev.setDate_added(developer.getDate_added());
        return  d_repo.save(dev);
    }



}

