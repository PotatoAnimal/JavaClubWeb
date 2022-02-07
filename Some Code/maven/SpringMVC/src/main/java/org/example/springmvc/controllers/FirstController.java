package org.example.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname, Model model) {
        //System.out.println(name + " " + surname);
        model.addAttribute("message", name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculate(@RequestParam(value = "a", required = false) String a,
                            @RequestParam(value = "b", required = false) String b,
                            @RequestParam(value = "action", required = false) String action,
                            Model model) {
        int a1 = Integer.parseInt(a);
        int b1 = Integer.parseInt(b);
        if (action.equals("multiplication")) {
            model.addAttribute("result", "a * b = " + (a1 * b1));
        }
        if (action.equals("addition")) {
            model.addAttribute("result", "a + b = " + (a1 + b1));
        }
        if (action.equals("subtraction")) {
            model.addAttribute("result", "a - b = " + (a1 - b1));
        }
        if (action.equals("division")) {
            model.addAttribute("result", "a / b = " + ((float)a1 / b1));
        }
        return "first/calculator";
    }
}
