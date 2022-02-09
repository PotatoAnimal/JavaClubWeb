package javaclub5.library.controllers;

import javaclub5.library.dao.BookDao;
import javaclub5.library.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BooksController {
    @Autowired
    BookDao bookDao;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("books", bookDao.readAll());
        return "books/bookslist";
    }
}
