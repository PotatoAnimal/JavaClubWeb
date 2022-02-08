package javaclub5.library.dao;

import javaclub5.library.models.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);
    void updateRole(User user);
    List<User> listRoles();
    User getRoleById(int id);
    void removeRole(int id);
}
