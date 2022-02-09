package javaclub5.library.dao;

import javaclub5.library.models.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(book);
    }

    @Override
    public void updateBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(book);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Book> listBooks() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Book> booksList = session.createQuery("from Book").list();
        return booksList;
    }

    @Override
    public Book getBookById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book =  session.load(Book.class, id);
        return book;
    }

    @Override
    public void removeBook(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = session.load(Book.class, id);
        if (null != book){
            session.delete(book);
        }
    }
}
