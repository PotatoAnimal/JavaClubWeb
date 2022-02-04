package javaclub5.library;

import javaclub5.library.config.SpringConfig;
import javaclub5.library.dao.UserDao;
import javaclub5.library.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class App{
    @Autowired
    UserDao userDao;

    public static void main(String[] args) {

        App app = new App();
        app.start(app.userDao);
    }

    public void start(UserDao userDao) {

        List<User> users = new LinkedList<>();
        users = userDao.readAll();
        System.out.println(users);
    }
}
