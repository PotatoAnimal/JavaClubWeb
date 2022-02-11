package javaclub5.library.service;


import javaclub5.library.models.Role;

import java.util.List;

public interface RoleService {

    public void addRole(Role role);
    public void updateRole(Role role);
    public List<Role> listRoles();
    public Role findRoleById(int id);
    public void removeRole(int id);

}
