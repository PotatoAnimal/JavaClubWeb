package javaclub5.library.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

    @GetMapping({"/home", "/Home", "/"})
    public String index() {
        return "home";
    }
}
