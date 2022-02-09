package javaclub5.library.service;

import javaclub5.library.models.Author;

import java.util.List;

public interface AuthorService {
    public void addAuthor(Author author);
    public void updateAuthor(Author author);
    public List<Author> listAuthors();
    public Author getAuthorById(int id);
    public void removeAuthor(int id);
}
