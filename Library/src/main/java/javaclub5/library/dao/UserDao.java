package javaclub5.library.dao;

import javaclub5.library.models.Role;
import javaclub5.library.models.User;
import javaclub5.library.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Component;


import java.sql.Date;
import java.time.Instant;
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
        Session session = HibernateUtil.sf.openSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery<User> query = session
                .createNativeQuery("SELECT * FROM library.users JOIN library.roles r on r.id = users.id_role and r.id = users.id_role", User.class);
        List<User> users = query.getResultList();
        transaction.commit();
        session.close();
        return users;
    }

    //need to fix id identity
    public User addUser(String name, String surname, String login, String password, String mail) {
        Session session = HibernateUtil.sf.openSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery<User> query = session
                .createNativeQuery("INSERT INTO library.users (id_role, name, surname, login, password, email,birthday) " +
                                "VALUES ((SELECT library.roles.id FROM library.roles WHERE name = 'Reader'),?1,?2,?3,?4,?5,?6)",
                        User.class);
//        #todo learn to set paras
        String userName = name;
        String userSurnamee = surname;
        String userLogin = login;
        String userPassword = password;
        String userEmail = mail;
        User addedUser = query
                .setParameter(1, userName)
                .setParameter(2, userSurnamee)
                .setParameter(3, userLogin)
                .setParameter(4, userPassword)
                .setParameter(5, userEmail)
                .setParameter(6, new Date(Instant.now().getEpochSecond()))
                .getSingleResult();
        transaction.commit();
        session.close();
        return addedUser;

    }

    public User removeUser() {

        return null;
    }


}
