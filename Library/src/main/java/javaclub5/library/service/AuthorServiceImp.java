package javaclub5.library.service;

import javaclub5.library.models.Author;
import javaclub5.library.models.User;
import javaclub5.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuthorServiceImp implements AuthorService{

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    @Transactional
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    @Transactional
    public List<Author> fetchAuthorList() {
        return (List<Author>) authorRepository.findAll();    }
}
