package javaclub5.library.service;

import javaclub5.library.models.Book;

import java.util.List;

public interface BookService {
    public List<Book> listBooks();

    public void addBook(Book book);


    public void updateBook(Book book);

    public void removeBook(int id);

    public Book getBookById(int id);
}
