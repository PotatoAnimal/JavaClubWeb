package javaclub5.library.service;

import javaclub5.library.dao.RoleDAO;
import javaclub5.library.models.Role;
import javaclub5.library.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Override
    @Transactional
    public void addRole(Role role) {
        this.roleDAO.addRole(role);
    }

    @Override
    @Transactional
    public void updateRole(Role role) {
        this.roleDAO.updateRole(role);
    }

    @Override
    @Transactional
    public List<Role> listRoles() {
        return this.roleDAO.listRoles();
    }

    @Override
    @Transactional
    public Role findRoleById(int id) {
        return this.roleDAO.findRoleById(id);
    }

    @Override
    @Transactional
    public void removeRole(int id) {
        this.roleDAO.removeRole(id);
    }
}
