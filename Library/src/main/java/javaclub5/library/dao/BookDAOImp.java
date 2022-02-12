package javaclub5.library.dao;

import javaclub5.library.models.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
    public void updateBook(Book book) {
        Session session = this.sf.getCurrentSession();
        session.update(book);

    }

    @Override
    public void deleteBookById(int bookId) {

    }

    @Override
    public Book findBookByAuthor(String authorName) {
        Session session = this.sf.getCurrentSession();
        Book book = (Book) session.createQuery("select b from Book b join fetch Author a on b.id = a.id where a.name = :name");
        return book;
    }
}
