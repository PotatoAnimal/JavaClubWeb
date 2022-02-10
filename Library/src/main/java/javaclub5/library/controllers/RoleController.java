package javaclub5.library.controllers;

import javaclub5.library.dao.AuthorDao;
import javaclub5.library.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    RoleDao roleDao;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("roles", roleDao.readAll());
        return "roles/roleslist";
    }
}