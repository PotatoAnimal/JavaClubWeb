package javaclub5.library.dao;

import javaclub5.library.models.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Repository
public class UserDAOImpl {
    @Autowired
    private SessionFactory sf;
    private List<User> users = new LinkedList<>();

    public UserDAOImpl() {

    }

    @Transactional
    public List<User> readAll() {
        users =  sf.getCurrentSession().createQuery("select u FROM User u " +
                            "join fetch Role r on u.role = r" ).list();
        return users;
    }

}
