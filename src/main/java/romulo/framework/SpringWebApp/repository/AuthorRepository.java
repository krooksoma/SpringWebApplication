package romulo.framework.SpringWebApp.repository;

import org.springframework.data.repository.CrudRepository;
import romulo.framework.SpringWebApp.domain.Author;

//CrudRepository take 2 arguments the Type and Id value
//
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
