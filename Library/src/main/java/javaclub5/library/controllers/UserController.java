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
//    @Autowired
//    UserDao userDao;
//
//    @GetMapping()
//    public String index(Model model) {
//        model.addAttribute("users", userDao.readAll());
//        return "users/list";
//    }

    @Autowired
    private UserService userService;

//    @Autowired(required = true)
//    @Qualifier(value = "roleService")
//    public void setRoleService(RoleService rs) {
//        this.roleService = rs;
//    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.listUsers());
        return "users/list";
    }

    //For add and update user both
    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User r) {
        if (r.getId() == 0) {
            //new user, add it
            this.userService.addUser(r);
        }else{
            //existing user, call update
            this.userService.updateUser(r);
        }

        return "redirect:/users";

    }

    @RequestMapping("/users/remove/{id}")
    public String removeUser(@PathVariable("id") int id){

        this.userService.removeUser(id);
        return "redirect:/users";
    }

    @RequestMapping("/users/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.listUsers());
        return "user";
    }

}
