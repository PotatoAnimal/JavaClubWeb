package javaclub5.library.dao;

import javaclub5.library.models.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
    public Author findAuthorById(int id) {
        Session session = this.sf.getCurrentSession();
        Author author = session.get(Author.class, id);
        return author;
    }

    @Override
    public void removeAuthor(int id) {
        Session session = this.sf.getCurrentSession();
        Author author = session.load(Author.class, id);
        if(author != null) {
            session.delete(author);
        }
    }
}
