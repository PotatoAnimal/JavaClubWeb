package javaclub5.library.controllers;

import javaclub5.library.dao.AuthorDao;
import javaclub5.library.dao.BookDao;
import javaclub5.library.dao.RegBooksDao;
import javaclub5.library.models.Author;
import javaclub5.library.models.Book;
import javaclub5.library.models.RegBooks;
import javaclub5.library.models.User;
import javaclub5.library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ManagerController {
    @Autowired
    UserService userService;
    @Autowired
    BookDao bookDao;
    @Autowired
    RegBooksDao regBooksDao;
    @Autowired
    AuthorDao authorDao;
    @GetMapping("/managerProfile")
    public String managerProfile(Model model) {
        model.addAttribute("userService", userService);
        model.addAttribute("books", bookDao.readAll());
        return "manager/managerProfile";
    }

    @GetMapping("/managerRegbooks")
    public String getManagerRegbooks(Model model) {
        model.addAttribute("regbooks", regBooksDao.readAll());
        return "manager/managerregbooks";
    }

    @PostMapping("/addNewRegistration")
    public String addNewRegbook(@ModelAttribute("book") Book book,
                                @ModelAttribute("author") Author author,
                                @ModelAttribute("regbooks") RegBooks regBooks,
                                Model model) {
        return "manager/manageraddnewregbook";
    }

    @PostMapping("/register")
    public String registerRegbook(@ModelAttribute("book") Book book,
                                @ModelAttribute("author") Author author,
                                @ModelAttribute("regbooks") RegBooks regBooks,
                                Model model) {
        authorDao.addAuthor(author);
        List<Author> authorList = new ArrayList<>();
        authorList.add(author);
        book.setAuthors(authorList);
        bookDao.addBook(book);
        regBooks.setBook(book);
        regBooksDao.create(regBooks);
        return "redirect: /managerRegbooks";
    }
}
