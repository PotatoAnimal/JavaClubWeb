package javaclub5.library.dao;

import javaclub5.library.models.Book;
import javaclub5.library.models.Role;
import javaclub5.library.models.User;
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

    @Transactional
    public void create(Role role) {
        sf.getCurrentSession().save(role);
    }

    @Transactional
    public Role readByID(int id) {
        Role role = sf.getCurrentSession().get(Role.class, id);
        return role;
    }

    @Transactional
    public void update(Role role) {
        sf.getCurrentSession().update(role);
    }

    @Transactional
    public void delete(Role role) {
        sf.getCurrentSession().delete(role);
    }
}