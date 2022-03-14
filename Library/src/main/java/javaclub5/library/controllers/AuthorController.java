package javaclub5.library.controllers;

import javaclub5.library.dao.AuthorDao;
import javaclub5.library.dto.NewAuthorDTO;
import javaclub5.library.dto.NewBookDTO;
import javaclub5.library.models.Author;
import javaclub5.library.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    AuthorDao authorDao;
    @Autowired
    AuthorService authorService;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("authors", authorDao.readAll());
        return "authors/authorslist";
    }

    @GetMapping("/addAuthor")
    public String addAuthor(Model model) {
        model.addAttribute("author", new NewAuthorDTO());
        return "authors/addNewAuthor";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute("author") NewAuthorDTO newAuthorDTO,
                         @RequestParam String name, @RequestParam String surname) {
        if (authorService.findAuthorByNameAndSurname(name, surname) != null) {
            return "redirect:/authors/addAuthor";
        } else {
            authorService.addAuthor(newAuthorDTO);
            return "redirect:/authors"; //need to finish
        }
    }

}
