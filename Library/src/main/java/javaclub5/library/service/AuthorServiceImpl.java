package javaclub5.library.service;

import javaclub5.library.dao.AuthorDAO;
import javaclub5.library.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDAO authorDAO;

    @Override
    @Transactional
    public void addAuthor(Author author) {
        this.authorDAO.addAuthor(author);
    }

    @Override
    @Transactional
    public void updateAuthor(Author author) {
        this.authorDAO.updateAuthor(author);
    }

    @Override
    @Transactional
    public List<Author> listAuthors() {
        return this.authorDAO.listAuthors();
    }

    @Override
    @Transactional
    public Author getAuthorById(int id) {
        return this.authorDAO.getAuthorById(id);
    }

    @Override
    @Transactional
    public void removeAuthor(int id) {
        this.authorDAO.removeAuthor(id);
    }
}
