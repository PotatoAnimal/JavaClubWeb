package javaclub5.library.dao;

import javaclub5.library.models.Book;

import java.util.List;

public interface BookDAO {
    List<Book> readAll();
    // save operation
    public void addBook(Book book);

    // read operation
    public List<Book> listBook();

//    public Book findByTitle(String bookTitle);

    // update operation
    public void updateBook(Book book);

    // delete operation
    public void deleteBookById(int bookId);

    public Book findBookByAuthor(String authorName);
}
