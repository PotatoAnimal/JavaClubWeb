package javaclub5.library.service;

import javaclub5.library.models.Book;
import javaclub5.library.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookServiceImp implements BookService {

    @Autowired
    private SessionFactory sf;


    @Override
    @Transactional
    public Book saveUser(Book book) {
        return null;
    }

    @Override
    @Transactional
    public List<Book> fetchBookList() {
        Session session = this.sf.getCurrentSession();
        List<Book> bookList = session.createQuery("from Book ").list();
        return bookList;
    }

//    @Override
//    @Transactional
//    public Book findByTitle(String bookTitle) {
//        return sf.findBookByTitle(bookTitle);
//    }

    @Override
    @Transactional
    public Book updateBook(Book book, Integer bookId) {
        return null;
    }
//
//    @Override
//    @Transactional
//    public void deleteBookById(int bookId) {
//        bookRepository.deleteBookById(bookId);
//    }
//
//    @Override
//    @Transactional
//    public Book findBookByAuthor(String authorName) {
//        return bookRepository.findBookByAuthor(authorName);
//    }

}
