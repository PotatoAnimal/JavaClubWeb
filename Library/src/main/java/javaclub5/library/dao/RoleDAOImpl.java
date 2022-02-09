package javaclub5.library.dao;

import javaclub5.library.models.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO{

    @Autowired
    private SessionFactory sessionFactory;

//    public void setSessionFactory(SessionFactory sf) {
//        this.sessionFactory = sf;
//    }

    @Override
    public void addRole(Role role) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(role);
    }

    @Override
    public void updateRole(Role role) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(role);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Role> listRoles() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Role> rolesList = session.createQuery("from Role").list();
        return rolesList;
    }

    @Override
    public Role getRoleById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
//        Role role = (Role) session.load(Role.class, new Integer(id));
        return session.load(Role.class, id);
    }

    @Override
    public void removeRole(int id) {
        Session session = this.sessionFactory.getCurrentSession();
//        Role role = (Role) session.load(Role.class, new Integer(id));
        Role role = session.load(Role.class, id);
        if (null != role) {
            session.delete(role);
        }

    }
}
