package javaclub5.library.dao;

import javaclub5.library.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void addUser(User user) {
        Session session = this.sf.getCurrentSession();
        session.persist(user);
    }

    @Transactional
    public List<User> readAll() {
        users = sf.getCurrentSession().createQuery("from User").list();
        return users;
    }

    @Transactional
    public void create(User user) {
        sf.getCurrentSession().save(user);
    }

    @Transactional
    public User readByID(int id) {
        User user = sf.getCurrentSession().get(User.class, id);
        return user;
    }

    @Transactional
    public void update(User user) {
        sf.getCurrentSession().update(user);
    }

    @Transactional
    public void delete(User user) {
        sf.getCurrentSession().delete(user);

    }

    @Transactional
    public User findByLogin(String login){
        Session session = sf.getCurrentSession();
        String hql = "select u from User u where u.login = :login";
        Query query = session.createQuery(hql);
        query.setParameter("login", login);
        return (query.list().isEmpty())
                ? null
                : (User) query.getSingleResult();
    }
}
