package javaclub5.library.services;

import javaclub5.library.dao.LogBookDao;
import javaclub5.library.models.Book;
import javaclub5.library.models.LogBook;
import javaclub5.library.models.User;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.stream.Collectors;


public class ReaderService extends UserService{
    @Autowired
    private LogBookDao logBookDao;

    /**
     *
     * @param user Reader
     * @return List of ordered books by Reader
     */
    public List<LogBook> getOrderedBooks(User user) {
        List<LogBook> orderedBooks = logBookDao.getUserStatistic(user);
        orderedBooks.stream().filter(t -> t.getDataOut().equals(null)).collect(Collectors.toList());
        return orderedBooks;
    }
}
