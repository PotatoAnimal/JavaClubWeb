package javaclub5.library.service;

import javaclub5.library.models.Book;
import java.util.List;

public interface ReaderService {
    public List<Book> listBook();
    List <Book> readAll();
    public List<Book> findByAuthor(String authorName);
}
