package javaclub5.library.controllers;

import javaclub5.library.models.Author;
import javaclub5.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthorsController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public String listAuthors(Model model){
        model.addAttribute("author", new Author());
        model.addAttribute("listAuthors", this.authorService.listAuthors());
        return "authors/list";
    }

    //For add and update author both
    @RequestMapping(value = "authors/add", method = RequestMethod.POST)
    public String addAuthor(@ModelAttribute("author") Author a){
        if (a.getId() ==0){
            //new author, add him
            this.authorService.addAuthor(a);
        }else{
            //existing author, call update
            this.authorService.updateAuthor(a);
        }

        return "redirect:/authors";
    }

    @RequestMapping("/authors/remove/{id}")
    public String removeAuthor(@PathVariable("id") int id){
        this.authorService.removeAuthor(id);
        return "redirect:/authors";
    }

    @RequestMapping("/authors/edit/{id}")
    public String editAuthor(@PathVariable("id") int id, Model model){
        model.addAttribute("author", this.authorService.getAuthorById(id));
        model.addAttribute("listAuthors", this.authorService.listAuthors());
        return "author";
    }
}
