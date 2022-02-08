package javaclub5.library.service;

import javaclub5.library.models.User;

import java.util.List;

public interface UserService {

    // save operation
    User saveUser(User user);

    // read operation
    List<User> fetchUserList();

    // update operation
    User updateUser(User user, Integer userId);

    // delete operation
    Object deleteUserById(Integer userId);

    public Long count();
}
