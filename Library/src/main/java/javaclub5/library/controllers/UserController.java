package javaclub5.library.controllers;

import javaclub5.library.dao.UserDAO;
import javaclub5.library.dao.UserDAOImp;
import javaclub5.library.models.User;
import javaclub5.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
//@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    String title = "";


//    @PostMapping("/new")
//    public String addUser(@RequestParam("name") String name, @RequestParam("surname") String surname,
//                          @RequestParam("login") String login, @RequestParam("password") String password,
//                          @RequestParam("email") String email, @RequestParam("birthdate") LocalDate date,
//                          Model model) {
//        User user = new User();
//
//        user.setName(name);
//        user.setSurname(surname);
//        user.setLogin(login);
//        user.setPassword(password);
//        user.setEmail(email);
//        user.setBirthday(date);
//
//        model.addAttribute("users", user);
//
//        return "users/new";
//    }

//    @GetMapping("/new")
//    public String addUser(Model model) {
//        model.addAttribute("user", new User());
//        return "users/new";
//    }
//
//    @PostMapping("/save")
//    public String create(@ModelAttribute("user") User user) {
//        userService.addUser(user);
//        return"redirect:/users";
//    }

    @GetMapping("/users")
    public String index(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users/usersList";
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
