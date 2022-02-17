package javaclub5.library.service;

import javaclub5.library.dto.NewBookDTO;
import javaclub5.library.models.Book;
import javaclub5.library.models.User;

import java.util.List;

public interface BookService {
    List <Book> readAll();
    // save operation
    public void addBook(NewBookDTO newBookDTO);

    // read operation
    public List<Book> listBook();

//    public Book findByTitle(String bookTitle);

    // update operation
    public void updateBook(Book book);

//    // delete operation
//    public void deleteBookById(int bookId);
//
    public List<Book> findBookByAuthor(String authorName, String surname);
    public List<Book> mostPopularAndUnpopular();

}
