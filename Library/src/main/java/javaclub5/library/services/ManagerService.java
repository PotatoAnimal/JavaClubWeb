package javaclub5.library.services;

import javaclub5.library.dao.AuthorDao;
import javaclub5.library.dao.BookDao;
import javaclub5.library.models.Author;
import javaclub5.library.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManagerService {
    @Autowired
    BookDao bookDao;
    @Autowired
    AuthorDao authorDao;

    public Book checkBook(Book book) {
        List<Book> books = bookDao.readAll();
        for (Book oldBook: books) {
            if (book.getTitle().trim().replaceAll("\\s{2,}", " ")
                    .equalsIgnoreCase(oldBook.getTitle())) {
                if(checkAuthor(book.getAuthors(), oldBook)) {
                    return oldBook;
                }
            }
        }
        authorDao.addAuthor(book.getAuthors().get(0));
        bookDao.addBook(book);
        return book;
    }

    public boolean checkAuthor(List<Author> authors, Book book) {
        List<Author> oldAuthors = book.getAuthors();
        for (Author author: oldAuthors) {
            if (author.getName()
                    .equalsIgnoreCase(authors.get(0).getName().replaceAll(" ", ""))
                    && author.getSurname()
                    .equalsIgnoreCase(authors.get(0).getSurname().replaceAll(" ", ""))) {
                return true;
            }
        }
        return false;
    }
}
