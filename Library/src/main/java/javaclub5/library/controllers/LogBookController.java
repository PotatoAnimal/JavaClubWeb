package javaclub5.library.controllers;


import javaclub5.library.dao.LogBookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logbook")
public class LogBookController {
    @Autowired
    LogBookDao logBookDao;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("logbooks", logBookDao.readAll());
        return "logbook/logbooklist";
    }
}