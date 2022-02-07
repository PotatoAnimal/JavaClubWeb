package javaclub5.library;


import javaclub5.library.dao.AuthorDao;
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

//        new BookDao().showAll();
//        new BookDao().createDummyBook("Joan","Harry Potter 1",1997);
//        new BookDao().findBookByName("Отверженные");
//        new BookDao().findBookByAuthor("Theodore");

//        new AuthorDao().addAuthor("Joan","Rowling");

//        new UserDao().addUser("Kris","Evans","krissss","3674","kris1@gmail.com");
        new UserDao().readAll();

    }

    public void start() {

    }
}
