package javaclub5.library.dao;


import javaclub5.library.models.RegBooks;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Repository
public class RegBooksDao {
    @Autowired
    private SessionFactory sf;
    private List<RegBooks> regBooks = new LinkedList<>();

    public RegBooksDao() {

    }

    @Transactional
    public List<RegBooks> readAll() {
        sf.getCurrentSession().createQuery("select b FROM Book b " +
                "join fetch b.Authors" ).list();
        regBooks =  sf.getCurrentSession().createQuery("from RegBooks ").list();
        return regBooks;
    }

}
