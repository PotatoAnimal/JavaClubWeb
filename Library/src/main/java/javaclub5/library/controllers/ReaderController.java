package javaclub5.library.controllers;

import javaclub5.library.dao.UserDao;
import javaclub5.library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ReaderController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;

    @PostMapping("/readers/{id}")
    public String goToReader(@PathVariable("id") int id, Model model) {
        model.addAttribute("books", userService.getBookList());
        model.addAttribute("userService", userService);
        model.addAttribute("user", userDao.readByID(id));
        model.addAttribute("id", id);
        return "readers/readerbookslist";
    }

    @PostMapping("/users/{id}")
    public String editReader(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDao.readByID(id));
        model.addAttribute("id", id);
        return "readers/readersedit";
    }

    @PostMapping("/reader/update")
    public String update(Model model) {
        model.addAttribute("user", userDao.readByID(id));
        return "redirect: /readers/" + user.getId());
    }

}
