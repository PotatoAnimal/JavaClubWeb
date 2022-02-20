package javaclub5.library.controllers;

import javaclub5.library.dao.BookDao;
import javaclub5.library.dao.UserDao;
import javaclub5.library.dto.NewBookDTO;
import javaclub5.library.services.BookService;
import javaclub5.library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BooksController {

    @Autowired
    BookDao bookDao;
    @Autowired
    private BookService bookService;

    @GetMapping("/addBook")
    public String addBook(Model model) {
        model.addAttribute("book", new NewBookDTO());
        return "books/addNewBook";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute("book") NewBookDTO newBookDTO) {
        bookService.addBook(newBookDTO);
        return "redirect:/books"; //need to finish
    }
}
