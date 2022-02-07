package javaclub5.library.util;

import javaclub5.library.models.Author;
import javaclub5.library.models.Book;
import javaclub5.library.models.Role;
import javaclub5.library.models.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    public static final SessionFactory sf;

    static {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(User.class)
                .addAnnotatedClass(Role.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Author.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        sf = configuration.buildSessionFactory();
    }
}
