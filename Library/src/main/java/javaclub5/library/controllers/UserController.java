package javaclub5.library.controllers;

import javaclub5.library.models.User;
import javaclub5.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

        @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users/list";
    }

//    @GetMapping()
//    public String index(Model model) {
//        model.addAttribute("users", userService.save(new User("Yura", "arcaniell", "1234", "stern@gmail.com", LocalDate.of(1993, 1, 10), "Sterniuk")));
//        return "users/list";
//    }

//    @GetMapping()
//    public String index(Model model) {
//        User user = userService.findByName("Anna");
//        model.addAttribute("users", user);
//        return "users/list";
//    }

}
