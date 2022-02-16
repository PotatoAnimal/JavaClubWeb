package javaclub5.library.controllers;

import javaclub5.library.models.User;
import javaclub5.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
//@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    String title = "";

    @PostMapping("/new")
    public String addUser(@RequestParam("name") String name, @RequestParam("surname") String surname,
                          @RequestParam("login") String login, @RequestParam("password") String password,
                          @RequestParam("email") String email, @RequestParam("birthdate") LocalDate date,
                          Model model) {
        User user = new User();

        user.setName(name);
        user.setSurname(surname);
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setBirthday(date);

        model.addAttribute("users", user);

        return "users/new";
    }

    @GetMapping("/users")
    public String index(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users/usersList";
    }

    @GetMapping("/books")
    public String readAll(Model model) {
        model.addAttribute("listBooks", userService.readAll());
        model.addAttribute("userService", userService);
        return "books/booksList";
    }

    @GetMapping("/booksByTitle")
    public String findByTitle(@RequestParam("title") String title, Model model) {
        model.addAttribute("books", userService.findByTitle(title));
        model.addAttribute("userService", userService);
        return "books/booksList";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
