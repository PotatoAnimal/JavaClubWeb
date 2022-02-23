package javaclub5.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagerController {
    @GetMapping("/managerProfile")
    public String managerProfile() {
        return "manager/managerProfile";
    }
}
