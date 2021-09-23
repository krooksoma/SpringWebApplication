package romulo.framework.SpringWebApp.repository;

import org.springframework.data.repository.CrudRepository;
import romulo.framework.SpringWebApp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
