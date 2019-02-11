package contactapi.demo.Repo;

import contactapi.demo.Entities.Developer;
import org.springframework.data.repository.CrudRepository;

public interface DeveloperRespository extends CrudRepository<Developer, Long> {
   Developer findByNick(String nick);

}
