package javaclub5.library.dao;

import javaclub5.library.models.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImp implements BookDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    public List<Book> readAll() {
        Session session = sf.getCurrentSession();
        return (List<Book>) session.createQuery("from Book ").list();
    }

    @Override
    public void addBook(Book book) {
        Session session = sf.getCurrentSession();
        session.persist(book);
    }

    @Override
    public List<Book> listBook() {
        Session session = this.sf.getCurrentSession();
        return (List<Book>) session.createQuery("from Book").list();
    }

    @Override
    public List<Book> findByTitle(String bookTitle) {
        Session session = this.sf.getCurrentSession();
        String hql = "select b from Book b join fetch RegBook r on b.id = r.count and b.id = r.price where b.title = :name ";
        Query query = session.createQuery(hql);
        query.setParameter("name", bookTitle);
        List<Book> book = query.list();
        return book;
    }

    @Override
    public void updateBook(Book book) {
        Session session = this.sf.getCurrentSession();
        session.update(book);

    }

    @Override
    public void deleteBookById(int bookId) {

    }

    @Override
    public List<Book> findByAuthor(String author) {
        Session session = this.sf.getCurrentSession();
        String hql = "select b from Book b join fetch Author a on b.id = a.id where a.name = :name";
        Query query = session.createQuery(hql);
        query.setParameter("name", author);
        List<Book> book = query.list();
        return book;
    }
}
