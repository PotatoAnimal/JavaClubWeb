package javaclub5.library.service;

import javaclub5.library.dao.AuthorDAO;
import javaclub5.library.dao.BookDAO;
import javaclub5.library.dto.NewBookDTO;
import javaclub5.library.models.Author;
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
    @Autowired
    private AuthorDAO authorDAO;


    @Override
    @Transactional
    public List<Book> readAll() {
        return this.bookDAO.readAll();
    }

    @Override
    @Transactional
    public void addBook(NewBookDTO newBookDTO) {

        Author author = authorDAO.findAuthorByNameAndSurname(newBookDTO.getAuthorName(), newBookDTO.getAuthorSurname());
//        this.bookDAO.addBook(newBookDTO);
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
