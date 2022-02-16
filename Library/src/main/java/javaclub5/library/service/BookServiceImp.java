package javaclub5.library.service;

import javaclub5.library.dao.BookDAO;
import javaclub5.library.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class BookServiceImp implements BookService {

    @Autowired
    private BookDAO bookDAO;
    private List<Book> books = new LinkedList<>();


    @Override
    @Transactional
    public List<Book> readAll() {
        return this.bookDAO.readAll();
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        this.bookDAO.addBook(book);
    }

    @Override
    @Transactional
    public List<Book> listBook() {
        return this.bookDAO.listBook();
    }

//    @Override
//    @Transactional
//    public Book findByTitle(String bookTitle) {
//        return sf.findBookByTitle(bookTitle);
//    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        this.bookDAO.updateBook(book);
    }

    //
//    @Override
//    @Transactional
//    public void deleteBookById(int bookId) {
//        bookRepository.deleteBookById(bookId);
//    }
//
    @Override
    @Transactional
    public List<Book> findBookByAuthor(String authorName, String surname) {
        return this.bookDAO.findByAuthor(authorName, surname);
    }

    @Override
    public List<Book> mostPopularAndUnpopular() {
        return this.bookDAO.mostPopularAndUnpopular();
    }

}
