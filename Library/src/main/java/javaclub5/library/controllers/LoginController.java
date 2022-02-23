package javaclub5.library.controllers;

import javaclub5.library.dto.UserDTO;
import javaclub5.library.models.User;
import javaclub5.library.services.UserService;
import javaclub5.library.userLoginService.SecurityService;
import javaclub5.library.userLoginService.UserDetailsServiceImpl;
import javaclub5.library.userLoginService.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

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
    public String login() {
        return "users/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout,
                            Model model, UserDTO userDTO) {
        String errorMessge = null;
        if (error != null) {
            errorMessge = "Username or Password is incorrect !!";
        }
        if (logout != null) {
            errorMessge = "You have been successfully logged out !!";
        }
        model.addAttribute("errorMessage", errorMessge);
        return "redirect:/readers/" + userDTO.getId();
    }

//    @PostMapping("/logout")
//    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null) {
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return "redirect:/login";
//    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:users/login";
    }

    @GetMapping("/loginRedirect")
    public String loginRedirect() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user = userService.findUserByLogin(username);

        if (user.getRole().getId() == 1) {
            return "redirect:/managerProfile";
        } else {
            return "redirect:/readers/" + user.getId();
        }

    }

}
