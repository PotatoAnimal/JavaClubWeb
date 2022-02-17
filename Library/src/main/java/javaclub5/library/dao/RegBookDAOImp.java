package javaclub5.library.dao;

import javaclub5.library.models.RegBook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class RegBookDAOImp implements RegBookDAO {
    @Autowired
    private SessionFactory sf;

    @Override
    @Transactional
    public List<RegBook> readAll() {
        Session session = this.sf.getCurrentSession();
        List<RegBook> regBooks = session.createQuery("SELECT r FROM RegBook r ").list();

        return regBooks;
    }

    @Override
    @Transactional
    public void create(RegBook regBook) {
        sf.getCurrentSession().save(regBook);
    }

    @Override
    @Transactional
    public RegBook readByID(int id) {
//        RegBook regBooks = sf.getCurrentSession().get(RegBook.class, id);
        Session session = this.sf.getCurrentSession();
        Query query = (Query) session.createQuery("select r from RegBook r where id = :id").list();
        query.setParameter("id", id);
        RegBook regBook = (RegBook) query.getResultList();
        return regBook;
    }

    @Override
    @Transactional
    public void update(RegBook regBook) {
        sf.getCurrentSession().update(regBook);
    }
}
