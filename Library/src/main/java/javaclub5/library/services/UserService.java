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
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        Pattern pattern = getPattern(title);
        List<Book> books = bookDao.readAll();
        List<Book> booksByTitle = new LinkedList<>();
        for (Book book : books) {
            Matcher matcher = pattern.matcher(book.getTitle().toLowerCase());
            if (matcher.find()) {
                booksByTitle.add(book);
            }
        }

        return booksByTitle;
    }

    public List<Book> getBookByAuthor(String name, String surname) {
        List<Book> booksByAuthor = new LinkedList<>();
        List<Book> books = bookDao.readAll();
        Pattern namePattern = getPattern(name);
        Pattern surnamePattern = getPattern(surname);
        for (Book book : books) {
            for (Author author : book.getAuthors()) {
                Matcher nameMatcher = namePattern.matcher(author.getName().toLowerCase());
                Matcher surnameMatcher = surnamePattern.matcher(author.getSurname().toLowerCase());
                if ((nameMatcher.find() && surnameMatcher.find()) |
                        (nameMatcher.find() && surname == null) |
                        (surnameMatcher.find() && name == null)) {
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
                regBooksAmount += regBook.getAmount() * regBook.getOperations();
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

    private Pattern getPattern(String title) {
        title = title.toLowerCase().trim().replaceAll("\\s{2,}", " ");
        Pattern pattern = Pattern.compile(title);
        return pattern;
    }
}
