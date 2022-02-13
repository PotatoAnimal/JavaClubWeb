package javaclub5.library.controllers;


import javaclub5.library.models.Role;
import javaclub5.library.service.roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RoleController {

    @Autowired
    private roleService roleService;

    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public String listRole(Model model){
        model.addAttribute("roles", new Role());
        model.addAttribute("listRole", this.roleService.listRole());
        return "roles/list";
    }

    @RequestMapping(value = "/roles/add", method = RequestMethod.POST)
    public String addRole(@ModelAttribute("roles") Role r){
        if (r.getId()==0){
            this.roleService.addRole(r);
        } else {
            this.roleService.updateRole(r);
        }
        return "redirect:/roles";
    }

    @RequestMapping(value = "/roles/remove/{id}")
    public String removeRole (@PathVariable("id") int id){
        this.roleService.removeRole(id);
        return "redirect:/roles";
    }

    @RequestMapping("/roles/edit/{id}")
    public String editRole(@PathVariable("id") int id, Model model){
        model.addAttribute("roles", this.roleService.findRoleById(id));
        model.addAttribute("listRole", this.roleService.listRole());
        return "roles";
    }
}
