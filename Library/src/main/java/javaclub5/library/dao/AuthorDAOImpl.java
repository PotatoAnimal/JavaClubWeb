package javaclub5.library.dao;

import javaclub5.library.models.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDAOImpl implements AuthorDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addAuthor(Author author) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(author);
    }

    @Override
    public void updateAuthor(Author author) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(author);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Author> listAuthors() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Author> authorsList = session.createQuery("from Author").list();
        return authorsList;
    }

    @Override
    public Author getAuthorById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Author author =  session.load(Author.class, id);
        return author;
    }

    @Override
    public void removeAuthor(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Author author = session.load(Author.class, id);
        if (null != author){
            session.delete(author);
        }
    }
}
