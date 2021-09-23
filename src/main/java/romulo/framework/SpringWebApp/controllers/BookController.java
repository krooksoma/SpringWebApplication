package romulo.framework.SpringWebApp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import romulo.framework.SpringWebApp.domain.Book;
import romulo.framework.SpringWebApp.repository.BookRepository;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //    map to specific url
    @RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());

//        this will tell in which directory it will find the view template. Inside resources/templates/books/list.html
        return "books/list";
    }


}
