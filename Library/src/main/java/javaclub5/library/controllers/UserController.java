package javaclub5.library.controllers;

import javaclub5.library.dao.UserDao;
import javaclub5.library.dto.UserDTO;
import javaclub5.library.models.User;
import javaclub5.library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class UserController {
    @Autowired
    UserDao userDao;
    @Autowired
    UserService userService;
    String title = "";


    @GetMapping("/users")
    public String index(Model model) {
        model.addAttribute("users", userDao.readAll());
        return "users/userslist";
    }

    @GetMapping("/registerNewUser")
    public String addUser(Model model) {
        model.addAttribute("user", new UserDTO());
        return "users/registerNewUser";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute("user") UserDTO userDTO) {
        userService.addUser(userDTO.convertToUser());
        return "redirect:/users";
    }

    @GetMapping("/books")
    public String findAllBooks(Model model) {
        model.addAttribute("books", userService.getBookList());
        model.addAttribute("userService", userService);
        return "books/bookslist";
    }

    @GetMapping("/booksbytitle")
    public String findBookByTitle(@RequestParam("title") String title, Model model) {
        model.addAttribute("books", userService.getBookByTitle(title));
        model.addAttribute("userService", userService);
        return "books/bookslist";
    }

    @GetMapping("/booksbyauthor")
    public String findBookByAuthor(@RequestParam("name") String name,
                                   @RequestParam("surname") String surname, Model model) {
        model.addAttribute("books", userService.getBookByAuthor(name, surname));
        model.addAttribute("userService", userService);
        return "books/bookslist";
    }

    @GetMapping("/popularbooks")
    public String findPopularBooks(@RequestParam("firstDate")
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate firstDate,
                                   @RequestParam("secondDate")
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate secondDate,
                                   Model model) {
        model.addAttribute("books",
                userService.findPopularBook(userService.getBookByDate(firstDate, secondDate)));
        model.addAttribute("userService", userService);
        return "books/bookslist";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
