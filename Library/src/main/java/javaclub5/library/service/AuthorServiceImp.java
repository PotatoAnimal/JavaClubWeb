package javaclub5.library.service;

import javaclub5.library.dao.AuthorDAO;
import javaclub5.library.models.Author;
import javaclub5.library.models.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuthorServiceImp implements AuthorService {

    @Autowired
    private AuthorDAO authorDAO;

    @Override
    @Transactional
    public void addAuthor(Author author) {
        this.authorDAO.addAuthor(author);
    }

    @Override
    @Transactional
    public void updateRole(Author author) {
        this.authorDAO.updateAuthor(author);
    }

    @Override
    @Transactional
    public List<Author> listAuthors() {
        return this.authorDAO.listAuthors();
    }

    @Override
    @Transactional
    public Author findAuthorById(int id) {
        return this.authorDAO.findAuthorById(id);
    }

    @Override
    @Transactional
    public void removeAuthor(int id) {
        this.authorDAO.removeAuthor(id);
    }
}
