package javaclub5.library.controllers;

import javaclub5.library.service.RegBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/regBooks")
public class RegBookController {
    @Autowired
    private RegBookService regBookService;

    @GetMapping("/")
    public String readAll(Model model){
        model.addAttribute("regBooksList", regBookService.readAll());
        model.addAttribute("regBookService", regBookService);
        return "regBooks/regBooksList";
    }
}
