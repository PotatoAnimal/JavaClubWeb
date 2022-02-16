package javaclub5.library.dao;

import javaclub5.library.models.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class BookDAOImp implements BookDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    @Transactional
    public List<Book> readAll() {
        Session session = sf.getCurrentSession();
        return (List<Book>) session.createQuery("from Book ").list();
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        Session session = sf.getCurrentSession();
        session.persist(book);
    }

    @Override
    @Transactional
    public List<Book> listBook() {
        Session session = this.sf.getCurrentSession();
        return (List<Book>) session.createQuery("from Book").list();
    }

    @Override
    @Transactional
    public List<Book> findByTitle(String bookTitle) {
        Session session = this.sf.getCurrentSession();
//        String hql = "select b from Book b join fetch RegBook r on b.id = r.id where b.title = :name ";
        String hql = "select b from Book b where b.title = :name ";
        Query query = session.createQuery(hql);
        query.setParameter("name", bookTitle);
        List<Book> book = query.list();
        return book;
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        Session session = this.sf.getCurrentSession();
        session.update(book);

    }

    @Override
    @Transactional
    public void deleteBookById(int bookId) {
        Session session = this.sf.getCurrentSession();
        Query query = (Query) session.createQuery("delete from Book b where b.id = :bookId").list();
        Book book = (Book) query.setParameter("bookId", bookId);
        session.delete(book);
    }

    @Override
    @Transactional
    public List<Book> findByAuthor(String author, String surname) {
        Session session = this.sf.getCurrentSession();
        String hql = "select b from Book b join fetch Author a on b.id = a.id where a.name = :name and a.surname = :surname";
        Query query = session.createQuery(hql);
        query.setParameter("name", author);
        query.setParameter("surname", surname);
        List<Book> book = query.list();
        return book;
    }


    //need to fix //supposed already start to work.
    @Override
    @Transactional
    public List<Book> availableBooks() {
        Session session = this.sf.getCurrentSession();
        String hql = "select b.title, a.name, a.surname, count(r) from Book b" +
                "         join Author a on b.idAuthor = a.id " +
                "         join RegBook r on r.amount =b.id group by b.title, a.name,a.surname";
        Query query = session.createQuery(hql);
        List<Book> availableBooks = (List<Book>) query.list();
        return availableBooks;
    }

    //need to fix
    @Override
    @Transactional
    public List<Book> mostPopularAndUnpopular() {
        Session session = this.sf.getCurrentSession();
        String hql = "SELECT  b.title, rb.idBook, COUNT(*)" +
                "FROM Book b join LogBook rb on b.id = rb.id" +
                " GROUP BY rb.idBook ORDER BY count(*) DESC";
        Query query = session.createQuery(hql);
        return (List<Book>) query.getResultList();
    }


}
