package javaclub5.library.dao;

import javaclub5.library.models.LogBook;
import javaclub5.library.models.RegBooks;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class LogBookDao {
    @Autowired
    private SessionFactory sf;
    private List<LogBook> logBooks = new LinkedList<>();
    public LogBookDao() {

    }

    @Transactional
    public List<LogBook> readAll() {
        logBooks = (List<LogBook>) sf.getCurrentSession().createQuery("select lb from LogBook lb " +
                "left join fetch lb.book b join fetch b.Authors")
                .list().stream().distinct().collect(Collectors.toList());
        return logBooks;
    }

    @Transactional
    public void create(LogBook logBook) {
        sf.getCurrentSession().save(logBook);
    }

    @Transactional
    public LogBook readByID(int id) {
        LogBook logBook = sf.getCurrentSession().get(LogBook.class, id);
        return logBook;
    }

    @Transactional
    public void update(LogBook logBook) {
        sf.getCurrentSession().update(logBook);
    }

    @Transactional
    public void delete(LogBook logBook) {
        sf.getCurrentSession().delete(logBook);
    }



}
