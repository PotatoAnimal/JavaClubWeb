package javaclub.library.controller;

import javaclub.library.model.Role;
import javaclub.library.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RoleController {

    private RoleService roleService;

    @Autowired(required = true)
    @Qualifier(value = "roleService")
    public void setRoleService(RoleService rs) {
        this.roleService = rs;
    }

    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public String listRoles(Model model) {
        model.addAttribute("role", new Role());
        model.addAttribute("listRoles", this.roleService.listRoles());
        return "role";
    }

    //For add and update role both
    @RequestMapping(value = "/roles", method = RequestMethod.POST)
    public String addRole(@ModelAttribute("role") Role r) {
        if (r.getId() == 0) {
            //new role, add it
            this.roleService.addRole(r);
        }else{
            //existing role, call update
            this.roleService.updateRole(r);
        }

        return "redirect:/roles";

    }

    @RequestMapping("/remove/{id}")
    public String removeRole(@PathVariable("id") int id){

        this.roleService.removeRole(id);
        return "redirect:/roles";
    }

    @RequestMapping("/edit/{id}")
    public String editRole(@PathVariable("id") int id, Model model){
        model.addAttribute("role", this.roleService.getRoleById(id));
        model.addAttribute("listRoles", this.roleService.listRoles());
        return "role";
    }

}
