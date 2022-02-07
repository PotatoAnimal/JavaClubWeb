package javaclub5.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/home", "/Home", "/"})
    public String index() {
        return "home";
    }
}
