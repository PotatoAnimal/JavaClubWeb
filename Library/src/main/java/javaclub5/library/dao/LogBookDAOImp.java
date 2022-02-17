package javaclub5.library.dao;

import javaclub5.library.models.LogBook;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class LogBookDAOImp implements LogBookDAO {
    @Autowired
    private SessionFactory sf;

    @Override
    @Transactional
    public List<LogBook> readAll() {
//        List<LogBook> logBooks = sf.getCurrentSession().createQuery("select lb from LogBook lb " +
//                        "left join fetch lb.idBook b")
//                .list();
        List<LogBook> logBooks = sf.getCurrentSession().createQuery("select lb from LogBook lb " +
                "join fetch lb.idBook b  join fetch lb.idUser u").list();

        return logBooks;
    }

    @Override
    @Transactional
    public void create(LogBook logBook) {
        sf.getCurrentSession().save(logBook);
    }

    @Override
    @Transactional
    public LogBook readByID(int id) {
        LogBook logBook = sf.getCurrentSession().get(LogBook.class, id);
        return logBook;
    }

    @Override
    @Transactional
    public void update(LogBook logBook) {
        sf.getCurrentSession().update(logBook);
    }

    @Override
    @Transactional
    public void delete(LogBook logBook) {
        sf.getCurrentSession().delete(logBook);
    }
}
