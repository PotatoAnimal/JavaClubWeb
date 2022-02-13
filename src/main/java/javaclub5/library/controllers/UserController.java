package javaclub5.library.controllers;


import javaclub5.library.models.User;
import javaclub5.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listUsers (Model model){
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.listUsers());
        return"users/list";
    }

    @RequestMapping (value = "/users/add", method = RequestMethod.POST)
    public String addUser (@ModelAttribute("user") User u){
        if (u.getId() == 0){
            this.userService.addUser(u);
        } else {
            this.userService.addUser(u);
        }
        return "redirect:/users";
    }

    @RequestMapping("/users/remove/{id}")
    public String removeUser (@PathVariable("id") int id){
        this.userService.removeUser(id);
        return "redirected:/users";
    }

    @RequestMapping("/users/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.listUsers());
        return "user";
    }
}
