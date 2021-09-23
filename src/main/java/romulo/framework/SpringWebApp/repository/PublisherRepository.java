package romulo.framework.SpringWebApp.repository;

import org.springframework.data.repository.CrudRepository;
import romulo.framework.SpringWebApp.domain.Publisher;


public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
