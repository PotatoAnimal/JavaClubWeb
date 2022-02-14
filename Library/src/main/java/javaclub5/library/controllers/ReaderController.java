package javaclub5.library.controllers;


import javaclub5.library.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reader")
public class ReaderController {

    @Autowired
    ReaderService readerService;

//    @GetMapping()
//    public String index(Model model) {
//        model.addAttribute("listBooks", readerService.readAll());
//        return "books/list";
//    }

//    @GetMapping()
//    public String index(Model model) {
//        model.addAttribute("listBooks", readerService.findByAuthor("Bruce"));
//        return "books/list";
//    }

    @GetMapping()
    public String findByAuthor(Model model) {
        model.addAttribute("listBooks", readerService.availableBooks());
        return "books/list";
    }
}
