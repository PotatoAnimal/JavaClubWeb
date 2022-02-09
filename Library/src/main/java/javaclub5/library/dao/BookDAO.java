package javaclub5.library.dao;

import javaclub5.library.models.Book;

import java.util.List;

public interface BookDAO {
    public void addBook(Book book);
    public void updateBook(Book book);
    public List<Book> listBooks();
    public Book getBookById(int id);
    public void removeBook(int id);
}
