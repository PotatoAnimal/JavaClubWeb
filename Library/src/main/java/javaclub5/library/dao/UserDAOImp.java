package javaclub5.library.dao;

import javaclub5.library.models.Book;
import javaclub5.library.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    @Transactional
    public void addUser(User user) {
        Session session = this.sf.getCurrentSession();
        session.persist(user);

    }

    @Override
    @Transactional
    public void updateUser(User user) {
        Session session = this.sf.getCurrentSession();
        session.update(user);
    }

    @Override
    @Transactional
    public List<User> listUsers() {
        Session session = this.sf.getCurrentSession();
        List<User> users = session.createQuery("from User").list();
        return users;
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        Session session = this.sf.getCurrentSession();
        User user = (User) session.load(User.class, id);
        return user;
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        Session session = this.sf.getCurrentSession();
        User user = (User) session.load(User.class, id);
        if (null != user) {
            session.delete(user);
        }
    }

}
