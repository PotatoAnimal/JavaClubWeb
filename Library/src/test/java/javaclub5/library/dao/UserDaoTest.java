package javaclub5.library.dao;

import javaclub5.library.config.SpringConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserDaoTest {
    @Autowired
    UserDao userDao;


    @Test
    public void userDAOTest() {

        userDao.findAll();
    }
}
