package javaclub5.library.service;


import javaclub5.library.dao.BookDAO;
import javaclub5.library.dao.RoleDAO;
import javaclub5.library.dao.UserDAO;
import javaclub5.library.models.Book;
import javaclub5.library.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;


@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private BookDAO bookDAO;
    @Autowired
    private RoleDAO roleDAO;

    @Override
    @Transactional
    public void addUser(User user) {
        user.setRole(roleDAO.findRoleById(2));
        this.userDAO.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        this.userDAO.updateUser(user);
    }

    @Override
    @Transactional
    public List<User> listUsers() {
        return this.userDAO.listUsers();
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return this.userDAO.getUserById(id);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        this.userDAO.removeUser(id);
    }

    @Override
    @Transactional
    public List<Book> readAll() {
        return this.bookDAO.readAll();
    }


    @Override
    public List<Book> findByTitle(String title) {
        return this.bookDAO.findByTitle(title);
    }

    @Override
    public List<Book> findByAuthor(String name, String surname) {
        return this.bookDAO.findByAuthor(name, surname);
    }


}
