package javaclub5.library.controllers;


import javaclub5.library.service.authorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthorController {

    @Autowired
    private authorService authorService;

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public String listAuthors(Model model){
        model.addAttribute("listAuthors", authorService.listAuthors());
        return "authors/list";
    }
}
