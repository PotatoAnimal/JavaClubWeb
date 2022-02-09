package javaclub5.library.dao;

import javaclub5.library.models.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
@Repository
public class BookDao {
    @Autowired
    private SessionFactory sf;
    private List<Book> books = new LinkedList<>();

    public BookDao() {

    }

    @Transactional
    public List<Book> readAll() {
        books =  sf.getCurrentSession().createQuery("FROM Book" ).list();
        System.out.println(books);
        return books;
    }
}
