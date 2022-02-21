package javaclub5.library.services;

import javaclub5.library.dao.RoleDao;
import javaclub5.library.dao.UserDao;
import javaclub5.library.dto.UserDTO;
import javaclub5.library.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    public void addRole(UserDTO userDTO) {
        Role role = userDTO.convertToRole();

        roleDao.create(role);
    }
}
