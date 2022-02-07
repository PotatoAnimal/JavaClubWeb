package javaclub5.library.dao;

import javaclub5.library.models.Book;
import javaclub5.library.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDao {

    public List<Book> showAll() {
        Session session = HibernateUtil.sf.openSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery<Book> query = session
                .createNativeQuery("SELECT id, title, yearProduction, idAuthor  FROM library.books",
                        Book.class);
//        #todo learn to set paras
        List<Book> allBooks = query.getResultList();
        transaction.commit();
        session.close();
        return allBooks;
    }

    public Book createDummyBook(String authorName, String titleName, int year) {
        Session session = HibernateUtil.sf.openSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery<Book> query = session
                .createNativeQuery("INSERT INTO library.books(idauthor,title,yearProduction) " +
                                "VALUES ((SELECT library.authors.id FROM library.authors WHERE name = ?1),?2,?3) RETURNING *",
                        Book.class);
//        #todo learn to set paras
        Book createdBook = query
                .setParameter(1, authorName)
                .setParameter(2, titleName)
                .setParameter(3, year)
                .getSingleResult();
        transaction.commit();
        session.close();
        return createdBook;
    }

    public Book findBookByTitle(String bookName) {
        Session session = HibernateUtil.sf.openSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery<Book> query = session
                .createNativeQuery("SELECT * FROM library.books WHERE title = ?1", Book.class);
        Book bookTitle = query.setParameter(1, bookName).getSingleResult();
        transaction.commit();
        session.close();
        return bookTitle;
    }

    public Book findBookByAuthor(String authorName) {
        Session session = HibernateUtil.sf.openSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery<Book> query = session
                .createNativeQuery("SELECT * FROM library.books b join library.authors a on b.id = a.id where name = ?1", Book.class);
        Book authorsName = query.setParameter(1, authorName).getSingleResult();
        transaction.commit();
        session.close();
        return authorsName;
    }

    public void deleteBookByName(String bookName) {
    }
}
