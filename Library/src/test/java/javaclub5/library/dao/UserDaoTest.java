package javaclub5.library.dao;

import javaclub5.library.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoTest {
    @Autowired
    UserRepository userDao;


    @Test
    public void userDAOTest() {

        userDao.findAll();
    }
}
