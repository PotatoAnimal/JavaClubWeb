package javaclub5.library.controllers;

import javaclub5.library.dao.RegBooksDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/regbooks")
public class RegBooksController {
    @Autowired
    RegBooksDao regBooksDao;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("regbooks", regBooksDao.readAll());
        return "regbooks/regbookslist";
    }
}
