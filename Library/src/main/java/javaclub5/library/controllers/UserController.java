package javaclub5.library.controllers;

import javaclub5.library.dao.UserDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserDAOImpl userDao;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userDao.readAll());
        return "users/list";
    }

}
