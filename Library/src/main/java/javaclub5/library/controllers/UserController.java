package javaclub5.library.controllers;

import javaclub5.library.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

public class UserController {
    @Autowired
    UserDao userDao;
}
