package javaclub5.library.service;

import javaclub5.library.models.Author;

import java.util.List;

public interface AuthorService {
    Author addAuthor(Author author);

    public List<Author> fetchAuthorList();
}
