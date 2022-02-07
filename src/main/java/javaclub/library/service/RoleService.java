package javaclub.library.service;

import javaclub.library.model.Role;
import javaclub.library.model.User;

import java.util.List;

public interface RoleService {
    public void addRole(Role role);
    public void updateRole(Role role);
    public List<Role> listRoles();
    public Role getRoleById(int id);
    public void removeRole(int id);
}
