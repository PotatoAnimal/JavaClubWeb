package javaclub5.library.dao;

import javaclub5.library.models.Role;

import java.util.List;

public interface RoleDAO {
    public void addRole(Role role);
    public void updateRole(Role role);
    public List<Role> listRoles();
    public Role getRoleById(int id);
    public void removeRole(int id);
}
