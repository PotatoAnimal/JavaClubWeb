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

    public Book createDummyBook() {
        Session session = HibernateUtil.sf.openSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery<Book> query = session
                .createNativeQuery("INSERT INTO library.books(title,yearProduction) VALUES ('test','1339') RETURNING *",
                        Book.class);
//        #todo learn to set paras
        Book createdBook = query.getSingleResult();
        transaction.commit();
        session.close();
        return createdBook;
    }

    public Book findBookByName(String bookName) {
//        Session session = HibernateUtil.sf.openSession();
//        Transaction transaction = session.beginTransaction();
//        NativeQuery<Book> query = session
//                .createNativeQuery("SELECT title FROM library.books WHERE title = ?1", Book.class);
//        String title = bookName;
//        Book bookTitle = query.setParameter(1, title).getSingleResult();
//        transaction.commit();
//        session.close();
        return null;
    }

    public void deleteBookByName(String bookName) {
    }

    public Book findBookByAuthor(String authorName) {
        return null;
    }

}
