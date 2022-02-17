package javaclub5.library.services;

import javaclub5.library.dao.LogBookDao;
import javaclub5.library.models.Book;
import javaclub5.library.models.LogBook;
import javaclub5.library.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReaderService extends UserService{
    @Autowired
    private LogBookDao logBookDao;

    /**
     * @param user Reader
     * @return List of ordered books by Reader
     */
    public List<LogBook> getOrderedBooks(User user) {
        List<LogBook> orderedBooks = logBookDao.getUserStatistic(user);
        orderedBooks = orderedBooks.stream().filter(t -> t.getDataOut() == null).collect(Collectors.toList());
        return orderedBooks;
    }

    /**
     *
     * @param user Reader
     * @return List of Books, that are reading now
     */
    public List<LogBook> getReadingBooks(User user) {
        List<LogBook> readingBooks = logBookDao.getUserStatistic(user);
        readingBooks = readingBooks.stream()
                .filter(t -> (t.getDataOut() != null && t.getDateIn() == null)).collect(Collectors.toList());
        return readingBooks;
    }
}
