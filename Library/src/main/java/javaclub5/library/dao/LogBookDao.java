package javaclub5.library.dao;

import javaclub5.library.models.Author;
import javaclub5.library.models.LogBook;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Repository
public class LogBookDao {
    @Autowired
    private SessionFactory sf;
    private List<LogBook> logBooks = new LinkedList<>();

    public LogBookDao() {

    }

    @Transactional
    public List<LogBook> readAll() {
        sf.getCurrentSession().createQuery("select b FROM Book b " +
                "join fetch b.Authors" ).list();
        logBooks =  sf.getCurrentSession().createQuery("from LogBook").list();
        return logBooks;
    }

}
