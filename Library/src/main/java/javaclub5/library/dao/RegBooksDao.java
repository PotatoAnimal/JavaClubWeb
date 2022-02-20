package javaclub5.library.dao;


import javaclub5.library.models.Author;
import javaclub5.library.models.Book;
import javaclub5.library.models.RegBooks;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RegBooksDao {
    @Autowired
    private SessionFactory sf;
    private List<RegBooks> regBooks = new LinkedList<>();

    public RegBooksDao() {

    }

    @Transactional
    public List<RegBooks> readAll() {
        regBooks = (List<RegBooks>) sf.getCurrentSession().createQuery("select rb from RegBooks rb " +
                        "left join fetch rb.book b ").
                list().stream().distinct().collect(Collectors.toList());
        for (RegBooks regBook : regBooks) {
            regBook.getBook().getAuthors().stream().distinct().collect(Collectors.toList());
        }
        return regBooks;
    }

    @Transactional
    public void create(RegBooks regBooks) {
        sf.getCurrentSession().save(regBooks);
    }

    @Transactional
    public RegBooks readByID(int id) {
        RegBooks regBooks = sf.getCurrentSession().get(RegBooks.class, id);
        return regBooks;
    }

    @Transactional
    public void update(RegBooks regBooks) {
        sf.getCurrentSession().update(regBooks);
    }

}
