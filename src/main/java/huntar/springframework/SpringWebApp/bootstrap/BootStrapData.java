package huntar.springframework.SpringWebApp.bootstrap;

import huntar.springframework.SpringWebApp.domain.Author;
import huntar.springframework.SpringWebApp.domain.Book;
import huntar.springframework.SpringWebApp.domain.Publisher;
import huntar.springframework.SpringWebApp.repository.AuthorRepository;
import huntar.springframework.SpringWebApp.repository.BookRepository;
import huntar.springframework.SpringWebApp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author gboyega = new Author("gboyega", "adeoti");
        Author happiness = new Author("happiness", "robinson");
        authorRepository.save(gboyega);
        authorRepository.save(happiness);

        Book gboyegaBook = new Book("just book", "12345");
        Book happinessBook = new Book("just happiness book", "12345");
        bookRepository.save(gboyegaBook);
        bookRepository.save(happinessBook);

        Publisher publisher = new Publisher("Adeoti", "Parkview Estate", "Lagos", "Okota", "101212");
        publisherRepository.save(publisher);

        gboyega.getBooks().add(gboyegaBook);
        gboyegaBook.getAuthors().add(gboyega);
        gboyegaBook.setPublisher(publisher);

        happiness.getBooks().add(happinessBook);
        happinessBook.getAuthors().add(happiness);
        happinessBook.setPublisher(publisher);

        publisher.getBooks().add(happinessBook);
        publisherRepository.save(publisher);
        publisher.getBooks().add(gboyegaBook);
        publisherRepository.save(publisher);


        System.out.println("Number of books is: " + bookRepository.count());
        System.out.println("Number of authors is: " + authorRepository.count());
        System.out.println("Number of books assigned to a publisher is: " + publisher.getBooks().size());

    }
}
