package javaclub5.library.controllers;

import javaclub5.library.dao.AuthorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    AuthorDao authorDao;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("authors", authorDao.readAll());
        return "authors/authorslist";
    }
}
