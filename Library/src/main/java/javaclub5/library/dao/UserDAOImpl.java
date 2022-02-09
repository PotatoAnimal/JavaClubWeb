package javaclub5.library.dao;

import javaclub5.library.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{
//    @Autowired
//    private SessionFactory sf;
//    private List<User> users = new LinkedList<>();
//
//    public UserDAOImpl() {
//
//    }
//
//    @Transactional
//    public List<User> readAll() {
//        users =  sf.getCurrentSession().createQuery("select u FROM User u " +
//                            "join fetch Role r on u.role = r" ).list();
//        return users;
//    }

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<User> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> usersList =  session.createQuery("from User").list();
        return usersList;
    }

    @Override
    public User getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
//        User user = (User) session.load(User.class, new Integer(id));
        User user = (User) session.load(User.class, id);
        return user;
    }

    @Override
    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        //User user = (User) session.load(User.class, new Integer(id));
        User user = (User) session.load(User.class, id);
        if (null != user) {
            session.delete(user);
        }
    }
}
