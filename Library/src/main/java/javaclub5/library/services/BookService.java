package javaclub5.library.services;

import javaclub5.library.dao.AuthorDao;
import javaclub5.library.dao.BookDao;
import javaclub5.library.dto.NewBookDTO;
import javaclub5.library.models.Author;
import javaclub5.library.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookService {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private AuthorDao authorDao;

    public void addBook(NewBookDTO newBookDTO) {
        Author author = authorDao.findAuthorByNameAndSurname(newBookDTO.getAuthorName(), newBookDTO.getAuthorSurname());
        if (author == null) {
            throw new IllegalArgumentException("Author not found.");
        }

        Book book = newBookDTO.convertToBook();
        book.setAuthors(List.of(author));
        bookDao.addBook(book);
        newBookDTO.setId(book.getId());
    }
}
