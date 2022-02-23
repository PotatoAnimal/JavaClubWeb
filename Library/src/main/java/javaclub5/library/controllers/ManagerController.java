package javaclub5.library.controllers;

import javaclub5.library.dao.BookDao;
import javaclub5.library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagerController {
    @Autowired
    UserService userService;
    @Autowired
    BookDao bookDao;
    @GetMapping("/managerProfile")
    public String managerProfile(Model model) {
        model.addAttribute("userService", userService);
        model.addAttribute("books", bookDao.readAll());
        return "manager/managerProfile";
    }
}
