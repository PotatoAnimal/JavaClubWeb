package javaclub5.library.service;

import javaclub5.library.models.Author;

import java.util.List;

public interface authorService {
    public List<Author> listAuthors();
    public void removeAuthor(int id);
    public void updateRole(Author author);
    public void addAuthor(Author author);
    public Author findAuthorById(int id);

}
