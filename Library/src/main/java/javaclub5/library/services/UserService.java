package javaclub5.library.services;

import javaclub5.library.dao.BookDao;
import javaclub5.library.dao.LogBookDao;
import javaclub5.library.dao.RegBooksDao;
import javaclub5.library.models.Author;
import javaclub5.library.models.Book;
import javaclub5.library.models.LogBook;
import javaclub5.library.models.RegBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserService {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private LogBookDao logBookDao;
    @Autowired
    private RegBooksDao regBooksDao;

    public List<Book> getBookList() {
        return bookDao.readAll();
    }

    public List<Book> getBookByTitle(String title) {
        List<Book> booksByTitle = bookDao.readAll();
        booksByTitle = booksByTitle.stream().filter(t -> t.getTitle()
                .equalsIgnoreCase(title)).collect(Collectors.toList());
        return booksByTitle;
    }

    public List<Book> getBookByAuthor(String name, String surname) {
        List<Book> booksByAuthor = new LinkedList<>();
        List<Book> books = bookDao.readAll();
        for (Book book : books) {
            for (Author author : book.getAuthors()) {
                boolean a1 = (author.getName().equalsIgnoreCase(name));
                boolean a2 = (author.getSurname().equalsIgnoreCase(surname));
                if ((author.getName().equalsIgnoreCase(name))
                        && (author.getSurname().equalsIgnoreCase(surname))) {
                    booksByAuthor.add(book);
                    break;
                }
            }
        }
        return booksByAuthor;
    }

    public List<Book> getBookByDate(LocalDate firstDate, LocalDate secondDate) {
        List<Book> booksByDate = new LinkedList<>();
        List<LogBook> logBooks = logBookDao.readAll();
        for (LogBook logBook: logBooks) {
            if (logBook.getDataOut().compareTo(firstDate) >=0
                    && logBook.getDataOut().compareTo(secondDate) <= 0) {
                booksByDate.add(logBook.getBook());
            }
        }
        return booksByDate;
    }

    public String isAvailable(Book book) {
        List<RegBooks> regBooks = regBooksDao.readAll();
        List<LogBook> logBooks = logBookDao.readAll();
        int regBooksAmount = 0;
        int logBookAmount = 0;
        for (RegBooks regBook: regBooks) {
            if (regBook.getBook().getId() == book.getId())
                regBooksAmount += regBook.getCount() * regBook.getOperations();
        }
        for (LogBook logBook: logBooks) {
            if (logBook.getBook().getId() == book.getId())
                logBookAmount ++;
        }
        if (regBooksAmount - logBookAmount > 0) {
            return "available";
        }
        else {
            return "unavailable";
        }
    }
}
