package javaclub5.library.controllers;

import javaclub5.library.dao.UserDao;
import javaclub5.library.models.User;
import javaclub5.library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller

public class ReaderController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;

    @GetMapping("/readers/{id}")
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

    @GetMapping("/reader/{id}/update")
    public String update(@PathVariable("id") int id,
                         @ModelAttribute("user") User user) {
        User oldUser = userDao.readByID(id);
        oldUser.setName(user.getName());
        oldUser.setSurname(user.getSurname());
        oldUser.setBirthday(user.getBirthday());
        userDao.update(oldUser);
        return "redirect: /readers/{id} ";
    }
}
