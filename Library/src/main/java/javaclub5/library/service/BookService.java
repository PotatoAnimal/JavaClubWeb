package javaclub5.library.service;

import javaclub5.library.models.Book;
import javaclub5.library.models.User;

import java.util.List;

public interface BookService {
    // save operation
    public Book saveUser(Book book);

    // read operation
    public List<Book> fetchBookList();

    public Book findByTitle(String bookTitle);

    // update operation
    public Book updateBook(Book book, Integer bookId);

    // delete operation
    public void deleteBookById(int bookId);

    public Book findBookByAuthor(String authorName);

}
