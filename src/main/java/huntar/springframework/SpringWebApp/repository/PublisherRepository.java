package huntar.springframework.SpringWebApp.repository;

import huntar.springframework.SpringWebApp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
