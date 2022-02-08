package javaclub5.library;


import javaclub5.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class App {
    @Autowired
    static UserRepository userDao;

    public static void main(String[] args) {
       /* AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);*/
       /* userDao = new UserDao();
        List<User> users = new LinkedList<>();
        users = userDao.readAll();
        System.out.println(users);
*/
       /* App app = new App();
        app.start();
    }*/

   /* public void start() {
        List<User> users = new LinkedList<>();
        users = userDao.readAll();
        System.out.println(users);
    }*/
    }
}
