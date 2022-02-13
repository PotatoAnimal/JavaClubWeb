package javaclub5.library.service;

import javaclub5.library.models.Role;

import java.util.List;

public interface roleService {
    public List<Role> listRole();
    public void addRole(Role role);
    public void updateRole(Role role);
    public void removeRole(int id);
    public Role findRoleById(int id);
}
