package javaclub5.library.dao;

import javaclub5.library.models.Role;
import javaclub5.library.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;


import java.util.LinkedList;
import java.util.List;

@Component
public class UserDao {

    private List<User> users = new LinkedList<>();

    private static UserDao userDaoInstance = null;
    private static Configuration configuration;
    private static StandardServiceRegistryBuilder builder;
    private static SessionFactory sf;

    static {
        configuration = new Configuration().configure();
        configuration.addAnnotatedClass(User.class)
                .addAnnotatedClass(Role.class);
        builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        sf = configuration.buildSessionFactory();
    }

    public UserDao() {

    }

    public List<User> readAll() {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        users =
                session.createQuery("FROM User as u INNER JOIN FETCH u.role as r").list();
        transaction.commit();
        session.close();
        return users;
    }

}
