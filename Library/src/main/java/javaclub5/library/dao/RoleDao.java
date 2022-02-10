package javaclub5.library.dao;

import javaclub5.library.models.Book;
import javaclub5.library.models.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Repository
public class RoleDao {
    @Autowired
    private SessionFactory sf;
    private List<Role> roles = new LinkedList<>();

    public RoleDao() {
    }

    @Transactional
    public List<Role> readAll() {
        roles =  sf.getCurrentSession().createQuery("FROM Role" ).list();
        System.out.println(roles);
        return roles;
    }
}