package javaclub5.library.dao;

import javaclub5.library.models.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserDaoImp {

    private SessionFactory sf;

//    @Override
//    public List<User> findByName(String name) {
//
//        List query = sf.getCurrentSession()
//                .createQuery("from User").list();
//
//        return query;
//    }


    public List<User> showAll() {
        List<User> users = sf.getCurrentSession()
                .createQuery("SELECT a FROM User a", User.class).getResultList();
        return users;
    }
}
