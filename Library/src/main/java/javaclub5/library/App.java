package javaclub5.library;


import javaclub5.library.config.SpringConfig;
import javaclub5.library.dao.UserDao;
import javaclub5.library.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.LinkedList;
import java.util.List;


public class App {
    @Autowired
    static UserDao userDao;

    public static void main(String[] args) {
       /* AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);*/
       /* userDao = new UserDao();
        List<User> users = new LinkedList<>();
        users = userDao.readAll();
        System.out.println(users);
*/
       /* App app = new App();
        app.start();
    }*/

   /* public void start() {
        List<User> users = new LinkedList<>();
        users = userDao.readAll();
        System.out.println(users);
    }*/
    }
}
