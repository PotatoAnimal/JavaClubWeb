package javaclub5.library.dao;

import javaclub5.library.models.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookDao {
    @Autowired
    private SessionFactory sf;
    private List<Book> books = new LinkedList<>();

    public BookDao() {

    }

    @Transactional
    public void addBook(Book book) {
        Session session = this.sf.getCurrentSession();
        session.persist(book);
    }

    @Transactional
    public List<Book> readAll() {
        books = (List<Book>) sf.getCurrentSession().createQuery("select b FROM Book b " +
                "left join fetch b.Authors").list().stream().distinct().collect(Collectors.toList());
        return books;
    }

    @Transactional
    public void create(Book book) {
        sf.getCurrentSession().save(book);
    }

    @Transactional
    public Book readByID(int id) {
        Book book = sf.getCurrentSession().get(Book.class, id);
        return book;
    }

    @Transactional
    public void update(Book book) {
        sf.getCurrentSession().update(book);
    }

    @Transactional
    public void delete(Book book) {
        sf.getCurrentSession().delete(book);
    }

    public boolean deleteBook(Book book) throws SQLException {

        Session session = sf.getCurrentSession();
        String sql = "DELETE FROM Book where id = :id";
        Query query = session.createQuery(sql);
        query.setParameter("id", book.getId());

        return query.executeUpdate() > 0;
    }

    /*
     * Count how many some book is reading now
     * */
    @Transactional
    public long getCountReadingBook(int idBook) {
        Session session = sf.getCurrentSession();
        String hql = "select count(*) from LogBook as lb where lb.book.id=:id and lb.dataOut is not null and lb.dateIn is null";
        Query cnt = session.createQuery(hql).setParameter("id", idBook);
        long countBook = 0;
        try {
            countBook = (long) cnt.uniqueResult();
        } catch (NullPointerException e) {
//            e.printStackTrace();
        }
        return countBook;
    }

    /*
     * Count how many some book is in library
     * */
    @Transactional
    public long getCountBook(int idBook) {
        Session session = sf.getCurrentSession();
        String hql = "select sum(rb.amount*rb.operations) from RegBooks rb where rb.book.id = :id";
        Query cnt = session.createQuery(hql).setParameter("id", idBook);
        long countBook = 0;
        try {
            countBook = (long) cnt.uniqueResult();
        } catch (NullPointerException e) {
//            e.printStackTrace();
        }
        return countBook;
    }

    @Transactional
    public long getCountAvailableBook(int idBook) {
        return getCountBook(idBook) - getCountReadingBook(idBook);
    }

    @Transactional
    public double getAverageDaysReadingBook(int idBook) {
        Session session = sf.getCurrentSession();
        String hql = "select avg(lb.dateIn-lb.dataOut) from LogBook as lb where lb.book.id=:id and lb.dataOut is not null and lb.dateIn is not null";
        Query cnt = session.createQuery(hql).setParameter("id", idBook);
        double daysReadingBook = 0;
        try {
            daysReadingBook = (double) cnt.uniqueResult();
        } catch (NullPointerException e) {
//            e.printStackTrace();
        }
        return daysReadingBook;
    }
}
