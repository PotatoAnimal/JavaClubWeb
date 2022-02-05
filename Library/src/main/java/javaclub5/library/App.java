package javaclub5.library;


import javaclub5.library.dao.UserDao;
import javaclub5.library.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.LinkedList;
import java.util.List;


public class App {
    @Autowired
    static UserDao userDao;

    public static void main(String[] args) {
        userDao = new UserDao();
        List<Users> users = new LinkedList<>();
        users = userDao.readAll();
        System.out.println(users);
    }

    public void start() {

    }
}
