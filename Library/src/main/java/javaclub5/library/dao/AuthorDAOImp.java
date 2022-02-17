package javaclub5.library.dao;

import javaclub5.library.models.Author;
import javaclub5.library.models.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AuthorDAOImp implements AuthorDAO {

    @Autowired
    private SessionFactory sf;

    @Override
    @Transactional
    public void addAuthor(Author author) {
        Session session = this.sf.getCurrentSession();
        session.persist(author);
    }

    @Override
    @Transactional
    public void updateAuthor(Author author) {
        Session session = this.sf.getCurrentSession();
        session.update(author);
    }

    @Override
    @Transactional
    public List<Author> listAuthors() {
        Session session = this.sf.getCurrentSession();
        List<Author> authorList = session.createQuery("from Author ").list();
        return authorList;
    }

    @Override
    @Transactional
    public Author findAuthorById(int id) {
        Session session = this.sf.getCurrentSession();
        Author author = session.get(Author.class, id);
        return author;
    }

    @Override
    @Transactional
    public void removeAuthor(int id) {
        Session session = this.sf.getCurrentSession();
        Author author = session.load(Author.class, id);
        if (author != null) {
            session.delete(author);
        }
    }

    @Override
    @Transactional
    public Author findAuthorByNameAndSurname(String name, String surname) {
        Session session = this.sf.getCurrentSession();
        String hql = "select a from Author a where a.name = :name AND a.surname = :surname";
        Query query = session.createQuery(hql);
        query.setParameter("name", name);
        query.setParameter("surname", surname);
        Author author = (Author) query.getSingleResult();
        return author;
    }
}
