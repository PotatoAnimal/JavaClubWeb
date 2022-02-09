package javaclub5.library.service;

import javaclub5.library.models.User;

import java.util.List;

public interface UserService {

    // save operation
    public User saveUser(User user);

    // read operation
    public List<User> fetchUserList();

    public User findByName(String name);

    // update operation
    public User updateUser(User user, Integer userId);

    // delete operation
    public void deleteUserById(int userId);

    public Long count();
}
