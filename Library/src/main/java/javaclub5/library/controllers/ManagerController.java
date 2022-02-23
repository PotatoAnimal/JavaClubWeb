package javaclub5.library.controllers;

import javaclub5.library.dao.BookDao;
import javaclub5.library.dao.RegBooksDao;
import javaclub5.library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ManagerController {
    @Autowired
    UserService userService;
    @Autowired
    BookDao bookDao;
    @Autowired
    RegBooksDao regBooksDao;
    @GetMapping("/managerProfile")
    public String managerProfile(Model model) {
        model.addAttribute("userService", userService);
        model.addAttribute("books", bookDao.readAll());
        return "manager/managerProfile";
    }

    @PostMapping("/managerRegbooks")
    public String getManagerRegbooks(Model model) {
        model.addAttribute("regbooks", regBooksDao.readAll());
        return "manager/managerregbooks";
    }

    @PostMapping("/addNewRegistration")
    public String addNewRegbook(Model model) {
        model.addAttribute("regbooks", regBooksDao.readAll());
        return "manager/managerregbooks";
    }
}
