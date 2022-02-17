package javaclub5.library.controllers;

import javaclub5.library.service.LogBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logBooks")
public class LogBookController {
    @Autowired
    private LogBookService logBookService;

    @GetMapping("/")
    public String readAll(Model model){
        model.addAttribute("logBooksList", logBookService.readAll());
        model.addAttribute("logBookService", logBookService);
        return "logBooks/logBooksList";
    }

}
