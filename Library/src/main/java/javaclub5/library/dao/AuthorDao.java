package javaclub5.library.dao;

import javaclub5.library.models.Author;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Repository
public class AuthorDao {
    @Autowired
    private SessionFactory sf;
    private List<Author> authors = new LinkedList<>();

    public AuthorDao() {

    }

    @Transactional
    public List<Author> readAll() {
        authors =  sf.getCurrentSession().createQuery("from Author").list();
        return authors;
    }

    @Transactional
    public void create(Author author) {
        sf.getCurrentSession().save(author);
    }

    @Transactional
    public Author readByID(int id) {
        Author author = sf.getCurrentSession().get(Author.class, id);
        return author;
    }

    @Transactional
    public void update(Author author) {
        sf.getCurrentSession().update(author);
    }

    @Transactional
    public void delete(Author author) {
        sf.getCurrentSession().delete(author);
    }

}
