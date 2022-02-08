package javaclub5.library.controllers;

import javaclub5.library.repository.UserRepository;
import javaclub5.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.fetchUserList());
        return "users/list";
    }

}
