package huntar.springframework.SpringWebApp.repository;

import huntar.springframework.SpringWebApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
