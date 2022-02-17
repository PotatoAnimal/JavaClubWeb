package javaclub5.library.controllers;

import javaclub5.library.dao.UserDAO;
import javaclub5.library.dao.UserDAOImp;
import javaclub5.library.dto.UserDTO;
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

    @GetMapping("/new")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute("user") UserDTO userDTO) {
        userService.addUser(userDTO.convertToUser());
        return"redirect:/users";
    }

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
