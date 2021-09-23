package romulo.framework.SpringWebApp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import romulo.framework.SpringWebApp.repository.BookRepository;

@Controller
public class BookControler {

    private final BookRepository bookRepository;

    public BookControler(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //    map to specific url
    @RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "books";
    }


}
