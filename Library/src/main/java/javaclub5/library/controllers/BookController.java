package javaclub5.library.controllers;


import javaclub5.library.service.BookService;
import javaclub5.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private UserService userService;



    @GetMapping("/")
    public String readAll(Model model) {
        model.addAttribute("listBooks", userService.readAll());
        model.addAttribute("userService", userService);
        return "books/booksList";
    }

    @GetMapping("/booksByTitle")
    public String findByTitle(@RequestParam("title") String title, Model model) {
        model.addAttribute("listBooks", userService.findByTitle(title));
        model.addAttribute("userService", userService);
        return "books/booksList";
    }

    @GetMapping("/booksByAuthor")
    public String findByAuthor(@RequestParam("name") String name, @RequestParam("surname") String surname,
                               Model model) {
        model.addAttribute("listBooks", userService.findByAuthor(name,surname));
        model.addAttribute("userService", userService);
        return "books/booksList";
    }
}
