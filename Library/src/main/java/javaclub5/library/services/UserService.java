package javaclub5.library.services;

import javaclub5.library.dao.*;
import javaclub5.library.dto.UserDTO;
import javaclub5.library.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
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
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<Book> getBookList() {
        return bookDao.readAll();
    }

    public void addUser(UserDTO userDTO) {
        User user = userDTO.convertToUser();
        user.setRole(roleDao.readByID(2));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.addUser(user);
        userDTO.setId(user.getId());
    }

    /**
     * @param title Book's title
     * @return List of Books by Title
     */
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

    /**
     * @param name    Author's name
     * @param surname Author's surname
     * @return List of Books by Author
     */
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

    /**
     * @param books List of books
     * @return most popular book
     */
    public List<Book> findPopularBook(List<Book> books) {
        List<Book> popularBooks = new LinkedList<>();
        Map<Book, Integer> popular = new HashMap<>();
        for (Book book : books) {
            if (popular.containsKey(book)) {
                int value = popular.get(book);
                value++;
                popular.put(book, value);
            } else {
                popular.put(book, 1);
            }
        }

        List<Integer> listValues = new ArrayList<>(popular.values());
        Collections.sort(listValues);
        if (!listValues.isEmpty()) {
            int max = listValues.get(listValues.size() - 1);
            for (Map.Entry<Book, Integer> entry : popular.entrySet()) {
                if (entry.getValue() == max) {
                    popularBooks.add(entry.getKey());
                }
            }
        }
        return popularBooks;
    }

    /**
     * @param firstDate
     * @param secondDate
     * @return return list of Books between firstDate and secondDate
     */
    public List<Book> getBookByDate(LocalDate firstDate, LocalDate secondDate) {
        List<Book> booksByDate = new LinkedList<>();
        List<LogBook> logBooks = logBookDao.readAll();
        for (LogBook logBook : logBooks) {
            if (logBook.getDataOut().compareTo(firstDate) >= 0
                    && logBook.getDataOut().compareTo(secondDate) <= 0) {
                booksByDate.add(logBook.getBook());
            }
        }
        return booksByDate;
    }

    /**
     * @param book
     * @return availability of book
     */
    public String isAvailable(Book book) {
        List<RegBooks> regBooks = regBooksDao.readAll();
        List<LogBook> logBooks = logBookDao.readAll();
        int regBooksAmount = 0;
        int logBookAmount = 0;
        for (RegBooks regBook : regBooks) {
            if (regBook.getBook().getId() == book.getId())
                regBooksAmount += regBook.getAmount() * regBook.getOperations();
        }
        for (LogBook logBook : logBooks) {
            if (logBook.getBook().getId() == book.getId() &&
                    logBook.getDateIn() == null && logBook.getDataOut() != null)
                logBookAmount++;
        }
        if (regBooksAmount - logBookAmount > 0) {
            return "available";
        } else {
            return "unavailable";
        }
    }

    /**
     * @param title
     * @return pattern for sorting books, authors etc.
     */
    private Pattern getPattern(String title) {
        title = title.toLowerCase().trim().replaceAll("\\s{2,}", " ");
        Pattern pattern = Pattern.compile(title);
        return pattern;
    }

    public long getCountReadingBook(int id) {
        return this.bookDao.getCountReadingBook(id);
    }

    public long getCountBook(int id) {
        return this.bookDao.getCountBook(id);
    }

    public long getCountAvailableBook(int id) {
        return this.bookDao.getCountAvailableBook(id);
    }

    public double getAverageDaysReadingBook(int id) {
        return this.bookDao.getAverageDaysReadingBook(id);
    }
}
