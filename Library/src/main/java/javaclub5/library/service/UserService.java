package javaclub5.library.service;

import javaclub5.library.models.Book;
import javaclub5.library.models.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {

    public void addUser(User user);
    public void updateUser(User user);
    public List<User> listUsers();
    public User getUserById(int id);
    public void removeUser(int id);
    public List<Book> readAll();
    public List<Book> findByTitle(String title);
}
