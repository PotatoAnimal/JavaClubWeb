package javaclub5.library.controllers;


import javaclub5.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping()
    public String listBooks(Model model) {
        model.addAttribute("listBooks", bookService.readAll());
        return "books/list";
    }


}
