package javaclub5.library.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoTest {
    @Autowired
    UserDAOImpl userDao;


    @Test
    public void userDAOTest() {

        userDao.listUsers();
    }
}
