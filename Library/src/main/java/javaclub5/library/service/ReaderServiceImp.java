package javaclub5.library.service;

import javaclub5.library.dao.BookDAO;
import javaclub5.library.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ReaderServiceImp implements ReaderService{
    @Autowired
    private BookDAO bookDAO;

    @Override
    @Transactional
    public List<Book> readAll() {
        return this.bookDAO.readAll();
    }

    @Override
    @Transactional
    public List<Book> listBook() {
        return this.bookDAO.listBook();
    }

    @Override
    @Transactional
    public List<Book> findByAuthor(String authorName, String surname) {
        return this.bookDAO.findByAuthor(authorName, surname);
    }

    @Override
    @Transactional
    public List<Book> availableBooks() {
        return this.bookDAO.availableBooks();
    }

    @Override
    @Transactional
    public List<Book> mostPopularAndUnpopular() {
        return this.bookDAO.mostPopularAndUnpopular();
    }

    @Override
    public List<Book> findByTitle(String title) {
        return this.bookDAO.findByTitle(title);
    }
}
