package contactapi.demo.Service;

import contactapi.demo.Entities.Developer;
import contactapi.demo.Repo.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
public class Controller {

    @Autowired
    Dao dao;



    @PostMapping(path = "/add")
    public Developer add(@RequestBody Developer dev){
        return dao.addDeveloper(dev);
    }


    @GetMapping(path = "/getById/{id}")
    public Developer get(@PathVariable(value = "id") Long id){
        return dao.findone(id);
    }

    @GetMapping(path = "/getByNick/{nick}")
    public Developer getByNick(@PathVariable(value = "nick") String nick){
        return dao.findByNick(nick);
    }

    @GetMapping(path = "/get/all")
    public Iterable<Developer> getAll(){
        return dao.findall();
    }


    @PostMapping(path = "/update/{id}",produces = "application/json")
    public Developer update(@PathVariable(value = "id") Long id, @RequestBody Developer dev){

        return dao.update(id,dev);
    }


    @GetMapping(path = "/delete/{id}", produces = "application/json")
    public Response delete(@PathVariable(value = "id") Long id){
        Response resp=new Response();
        if(dao.Delete(id)){
            resp.setCode(00);
            resp.setMessage("successful");
        }else{
            resp.setCode(12);
            resp.setMessage("Something is wrong");
        };

        return resp;
    }




}
