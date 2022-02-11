package javaclub5.library.controllers;

import javaclub5.library.models.Author;
import javaclub5.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public String listAuthors(Model model) {
//        model.addAttribute("authors", new Author());
        model.addAttribute("listAuthors", authorService.listAuthors());
        return "authors/list";
    }
}
