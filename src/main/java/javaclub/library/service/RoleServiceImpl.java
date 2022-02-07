package javaclub.library.service;

import javaclub.library.dao.RoleDAO;
import javaclub.library.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDAO roleDAO;

    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

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
    public Role getRoleById(int id) {
        return this.roleDAO.getRoleById(id);
    }

    @Override
    @Transactional
    public void removeRole(int id) {
        this.roleDAO.removeRole(id);
    }
}
