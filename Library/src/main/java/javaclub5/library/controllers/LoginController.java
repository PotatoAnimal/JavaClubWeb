package javaclub5.library.controllers;

import javaclub5.library.dto.UserDTO;
import javaclub5.library.services.UserService;
import javaclub5.library.userLoginService.SecurityService;
import javaclub5.library.userLoginService.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registerNewUser")
    public String registration(Model model) {
        model.addAttribute("user", new UserDTO());

        return "users/registerNewUser";
    }

    @PostMapping("/registerNewUser")
    public String registration(@ModelAttribute("user") UserDTO userDto, BindingResult bindingResult) {
        userValidator.validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "users/registerNewUser";
        }

        userService.addUser(userDto);
        securityService.autoLogin(userDto.getLogin(), userDto.getPassword());
        return "redirect:/readers/" + userDto.getId();
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");


        return "users/login";
    }

}
