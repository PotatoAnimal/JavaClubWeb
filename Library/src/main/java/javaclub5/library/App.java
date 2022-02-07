package javaclub5.library;


import javaclub5.library.dao.BookDao;
import javaclub5.library.dao.UserDao;
import javaclub5.library.models.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;


public class App {

    @Autowired
    static UserDao userDao;

    public static void main(String[] args) throws SQLException {
//        new BookDao().createDummyBook();
        new BookDao().findBookByName("test");

        userDao = new UserDao();
        List<User> users = userDao.readAll();
        System.out.println(users);
    }

    public void start() {

    }
}
