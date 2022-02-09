package javaclub5.library.dao;

import javaclub5.library.models.Role;
import javaclub5.library.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private SessionFactory sf;
    private List<User> users = new LinkedList<>();

    public UserDao() {

    }

    @Transactional
    public List<User> readAll() {
        /*users =  sf.getCurrentSession().createQuery("select u FROM User u " +
                            "join fetch Role r on u.role = r" ).list();*/
        users =  sf.getCurrentSession().createQuery("from User").list();
        System.out.println(users);
        return users;
    }

}
