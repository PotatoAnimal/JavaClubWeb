package javaclub5.library.controllers;

import javaclub5.library.models.Role;
import javaclub5.library.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private RoleService roleService;

//    @Autowired(required = true)
//    @Qualifier(value = "roleService")
//    public void setRoleService(RoleService rs) {
//        this.roleService = rs;
//    }

//    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    @GetMapping()
    public String listRoles(Model model) {
        model.addAttribute("role", new Role());
        model.addAttribute("listRoles", this.roleService.listRoles());
        return "roles/list";
    }

    //For add and update role both
//    @RequestMapping(value = "/roles/add", method = RequestMethod.POST)
    @GetMapping("/add")
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

//    @RequestMapping("/roles/remove/{id}")
    @GetMapping("/remove/{id}")
    public String removeRole(@PathVariable("id") int id){

        this.roleService.removeRole(id);
        return "redirect:/roles";
    }

//    @RequestMapping("/roles/edit/{id}")
    @GetMapping("/edit/{id}")
    public String editRole(@PathVariable("id") int id, Model model){
        model.addAttribute("role", this.roleService.getRoleById(id));
        model.addAttribute("listRoles", this.roleService.listRoles());
        return "role";
    }

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
        List<Role> result = roleService.getRolesByName(keyword);
        ModelAndView mav = new ModelAndView("roles/search");
        mav.addObject("result", result);
        return mav;
    }

//    @RequestMapping("/search")
//    public String search(@RequestParam String keyword) {
////        model.addAttribute("role", new Role());
////        model.addAttribute("listRoles", this.roleService.listRoles());
//        List<Role> result = roleService.getRolesByName(keyword);
//        ModelAndView mav = new ModelAndView("search");
//        mav.addObject("result", result);
//        return "roles/search";
//    }

}
