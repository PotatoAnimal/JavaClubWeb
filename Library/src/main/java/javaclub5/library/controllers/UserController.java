package javaclub5.library.controllers;

import javaclub5.library.models.User;
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

//    @GetMapping()
//    public String index(Model model) {
//        User user = userService.findByName("Steve");
//        model.addAttribute("users", user);
//        return "users/list";
//    }

}
