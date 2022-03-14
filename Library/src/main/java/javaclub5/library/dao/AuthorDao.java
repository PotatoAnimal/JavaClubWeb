package javaclub5.library.dao;

import javaclub5.library.models.Author;
import javaclub5.library.models.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AuthorDao {
    @Autowired
    private SessionFactory sf;
    private List<Author> authors = new LinkedList<>();

    public AuthorDao() {

    }

    @Transactional
    public void addAuthor(Author author) {
        Session session = this.sf.getCurrentSession();
        session.persist(author);
    }

    @Transactional
    public List<Author> readAll() {
        authors = sf.getCurrentSession().createQuery("from Author").list();
        authors = authors.stream().distinct().collect(Collectors.toList());
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

    @Transactional
    public Author findAuthorByNameAndSurname(String name, String surname) {
        Session session = this.sf.getCurrentSession();
        String hql = "select a from Author a where a.name = :name AND a.surname = :surname";
        Query query = session.createQuery(hql);
        query.setParameter("name", name);
        query.setParameter("surname", surname);
        return (query.list().isEmpty())
                ? null
                : (Author) query.getSingleResult();
    }

}
