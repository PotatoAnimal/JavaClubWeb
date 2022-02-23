package javaclub5.library.controllers;

import javaclub5.library.dao.BookDao;
import javaclub5.library.dto.NewBookDTO;
import javaclub5.library.models.Book;
import javaclub5.library.services.BookService;
import javaclub5.library.services.RegBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BookService bookService;

    @Autowired
    private RegBooksService regBooksService;


    @GetMapping("/addBook")
    public String addBook(Model model) {
        model.addAttribute("book", new NewBookDTO());
        return "books/addNewBook";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute("book") NewBookDTO newBookDTO) {
        bookService.addBook(newBookDTO);
        regBooksService.addRegBook(newBookDTO);
        return "redirect:/books"; //need to finish
    }

    @PostMapping("/manager/deleteBook/{idBook}")
    public String deleteBook(@PathVariable("idBook") int idBook, Model model) {
        bookService.deleteBook(idBook);
        model.addAttribute("idBook", idBook);
        return "redirect:/books";
    }
}
