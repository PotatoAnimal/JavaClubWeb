package javaclub.library.service;

import javaclub.library.model.Book;
import javaclub.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {
    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAvailableBooks(){
        return bookRepository.getAvailableBooks();
    }

    public void add(Book book){
        bookRepository.save(book);
    }
}
