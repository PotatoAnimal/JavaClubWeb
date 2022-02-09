package javaclub5.library.service;

import javaclub5.library.models.Role;
import javaclub5.library.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void addRole(Role role) {

    }

    @Override
    public void updateRole(Role role) {

    }

    @Override
    public List<Role> listRoles() {
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    public Role findRoleById(int id) {
        return null;
    }

    @Override
    public void removeRole(int id) {

    }
}
