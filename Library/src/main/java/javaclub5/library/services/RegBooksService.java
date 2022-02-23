package javaclub5.library.services;

import javaclub5.library.dao.BookDao;
import javaclub5.library.dao.RegBooksDao;
import javaclub5.library.dto.NewBookDTO;
import javaclub5.library.models.RegBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegBooksService {

    @Autowired
    private RegBooksDao regBooksDao;

    @Autowired
    private BookDao bookDao;

    public void addRegBook(NewBookDTO newBookDTO) {
        RegBooks regBooks = newBookDTO.convertToRegBook();
        regBooks.setBook(bookDao.readByID(newBookDTO.getId()));
        regBooksDao.create(regBooks);
    }
}
