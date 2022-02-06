package javaclub.library.repository;

import javaclub.library.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;

//@Repository
@Component
public class BookRepository {
    private List<Book> books;

    public List<Book> getAvailableBooks() {
        return books;
    }

    public Book findByTitle(String title) {
        return books.stream().filter(p -> p.getTitle().equals(title)).findFirst().get();
    }

    public void save(Book book){
        books.add(book);
    }
}
