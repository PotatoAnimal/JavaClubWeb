package javaclub5.library.service;

import javaclub5.library.dao.BookDAO;
import javaclub5.library.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookDAO bookDAO;

    @Override
    @Transactional
    public void addBook(Book book) {
        this.bookDAO.addBook(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        this.bookDAO.updateBook(book);
    }

    @Override
    @Transactional
    public List<Book> listBooks() {
        return this.bookDAO.listBooks();
    }

    @Override
    @Transactional
    public Book getBookById(int id) {
        return this.bookDAO.getBookById(id);
    }

    @Override
    @Transactional
    public void removeBook(int id) {
        this.bookDAO.removeBook(id);
    }
}
