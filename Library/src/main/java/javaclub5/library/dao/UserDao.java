package javaclub5.library.dao;

import javaclub5.library.models.Roles;
import javaclub5.library.models.Users;
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

    private List<Users> users = new LinkedList<>();

    private static UserDao userDaoInstance = null;
    private static Configuration configuration;
    private static StandardServiceRegistryBuilder builder;
    private static SessionFactory sf;

    static {
        configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Users.class)
                .addAnnotatedClass(Roles.class);
        builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        sf = configuration.buildSessionFactory();
    }

    public UserDao() {

    }

    public List<Users> readAll() {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        users =
                session.createQuery("from Users u join Roles on u.idRole=Roles ").list();
        transaction.commit();
        session.close();
        return users;
    }

}
