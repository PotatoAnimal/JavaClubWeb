package javaclub5.library.service;

import javaclub5.library.models.Role;

import java.util.List;

public interface RoleService {
    public void addRole(Role role);
    public void updateRole(Role role);
    public List<Role> listRoles();
    public Role getRoleById(int id);
    public List<Role> getRolesByName(String name);
    public void removeRole(int id);
}
