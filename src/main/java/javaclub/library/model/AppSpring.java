package javaclub.library.model;

import javaclub.library.config.AnnotatedBean;
import javaclub.library.config.AppConfig;
import javaclub.library.dao.UserDAOImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppSpring {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Author.class)
                .addAnnotatedClass(Role.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
//            Author author = new Author();
//            author.setName("Rowling1");
//            session.beginTransaction();
//            session.save(author);
//            session.getTransaction().commit();


//            ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        Author author = context.getBean("author", Author.class);
//        Book book = context.getBean("book", Book.class);

            //Annotated
//            AnnotatedBean annAuthor = context.getBean("author", AnnotatedBean.class);
//            AnnotatedBean annUser = context.getBean("user", AnnotatedBean.class);
//            new UserDAOImpl().listUsers();
//            System.out.println(annAuthor);

            //((AnnotationConfigApplicationContext) context).close();
        }finally {
            session.close();
            factory.close();
        }
    }
}
