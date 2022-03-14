package javaclub5.library.services;

import javaclub5.library.dao.AuthorDao;
import javaclub5.library.dto.NewAuthorDTO;
import javaclub5.library.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorService {
    @Autowired
    private AuthorDao authorDao;

    public void addAuthor(NewAuthorDTO newAuthorDTO) {
        Author author = authorDao.findAuthorByNameAndSurname(newAuthorDTO.getName(), newAuthorDTO.getSurname());
        if (author != null) {
            throw new IllegalArgumentException("Already have this author in the list!");
        }

        Author newAuthor = newAuthorDTO.convertToAuthor();
        authorDao.addAuthor(newAuthor);
    }

    public Author findAuthorByNameAndSurname(String name, String surname) {
        return authorDao.findAuthorByNameAndSurname(name, surname);
    }
}
