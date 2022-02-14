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
//    @GetMapping("/add")
//    public String addRole(@ModelAttribute("role") Role r) {
//        if (r.getId() == 0) {
//            //new role, add it
//            this.roleService.addRole(r);
//        }else{
//            //existing role, call update
//            this.roleService.updateRole(r);
//        }
//        return "redirect:/roles";
//    }
    @GetMapping("/new")
    public String newRoleForm(Model model){
        model.addAttribute("role", new Role());
        return "/roles/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("role") Role role){
        this.roleService.addRole(role);
        return "redirect:/roles";
    }

    @GetMapping("/edit/{id}")
    public String editRoleForm(@PathVariable("id") int id, Model model){
        model.addAttribute("role", this.roleService.getRoleById(id));
//        model.addAttribute("listRoles", this.roleService.listRoles());
        return "roles/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("role") Role role, @PathVariable("id") int id){
        this.roleService.updateRole(role);
        return "redirect:/roles";
    }

    @GetMapping("/remove/{id}")
    public String removeRole(@PathVariable("id") int id){

        this.roleService.removeRole(id);
        return "redirect:/roles";
    }

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
        List<Role> result = roleService.getRolesByName(keyword);
        ModelAndView mav = new ModelAndView("roles/search");
        mav.addObject("result", result);
        return mav;
    }

}
