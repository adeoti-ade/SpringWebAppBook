package huntar.springframework.SpringWebApp.repository;

import huntar.springframework.SpringWebApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
