package javaclub5.library.dao;

import javaclub5.library.models.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDAOImp implements RoleDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public void addRole(Role role) {
        Session session = this.sf.getCurrentSession();
        session.persist(role);
    }

    @Override
    public void updateRole(Role role) {
        Session session = this.sf.getCurrentSession();
        session.update(role);
    }

    @Override
    public List<Role> listRoles() {
        Session session = this.sf.getCurrentSession();
        List<Role> roleList = session.createQuery("from Role").list();
        return roleList;
    }

    @Override
    public Role findRoleById(int id) {
        Session session = this.sf.getCurrentSession();
        Role role = session.load(Role.class, id);
        return role;
    }

    @Override
    public void removeRole(int id) {
        Session session = this.sf.getCurrentSession();
        Role role = session.load(Role.class, id);
        if(role != null) {
            session.delete(role);
        }
    }
}
