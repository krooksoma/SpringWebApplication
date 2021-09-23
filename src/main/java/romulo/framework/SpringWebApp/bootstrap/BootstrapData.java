package romulo.framework.SpringWebApp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import romulo.framework.SpringWebApp.domain.Author;
import romulo.framework.SpringWebApp.domain.Book;
import romulo.framework.SpringWebApp.domain.Publisher;
import romulo.framework.SpringWebApp.repository.AuthorRepository;
import romulo.framework.SpringWebApp.repository.BookRepository;
import romulo.framework.SpringWebApp.repository.PublisherRepository;

//Tells spring framework to detect this as a spring management component

@Component
public class BootstrapData implements CommandLineRunner {
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

//    When spring implements this component it gonna bring context and will do dependency injection
//    into the constructor for an instance of author and book repository
    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher("Abril", "123 Lost Corner", "Legoland", "23343");
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "55554");

        publisherRepository.save(publisher);

        System.out.println("Publisher count: " + publisherRepository.count());

//    injects an instance of the  book to eric books HashSet
//    add the author to that specific book hashlist
//  save the author to author repository
//  save the book to book repository

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);


        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development ", "2344332");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(noEJB);
        publisher.getBooks().add(ddd);


        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher number of Books: " + publisher.getBooks().size());
    }
}
