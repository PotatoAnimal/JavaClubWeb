package javaclub5.library.service;

import javaclub5.library.dao.RoleDAO;
import javaclub5.library.models.Role;
import javaclub5.library.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public void addRole(Role role) {
        this.roleDAO.addRole(role);
    }

    @Override
    public void updateRole(Role role) {
        this.roleDAO.updateRole(role);
    }

    @Override
    public List<Role> listRoles() {
        return this.roleDAO.listRoles();
    }

    @Override
    public Role findRoleById(int id) {
        return this.roleDAO.findRoleById(id);
    }

    @Override
    public void removeRole(int id) {
        this.roleDAO.removeRole(id);
    }
}
