package javaclub5.library.dao;

import javaclub5.library.models.Author;
import javaclub5.library.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.Instant;

@Component
public class AuthorDao {

    public Author addAuthor(String name, String surname) {
        Session session = HibernateUtil.sf.openSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery<Author> query = session
                .createNativeQuery("INSERT INTO library.authors(name,surname,birthday) VALUES (?1, ?2, ?3) RETURNING *",
                        Author.class);
//        #todo learn to set paras
        String authorName = name;
        String authorSurnamee = surname;
        Author addedAuthor = query
                .setParameter(1, authorName)
                .setParameter(2, authorSurnamee)
                .setParameter(3, new Date(Instant.now().getEpochSecond()))
                .getSingleResult();
        transaction.commit();
        session.close();
        return addedAuthor;
    }
}
