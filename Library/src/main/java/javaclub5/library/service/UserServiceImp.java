package javaclub5.library.service;

import javaclub5.library.models.Role;
import javaclub5.library.models.User;
import javaclub5.library.repository.RoleRepository;
import javaclub5.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transaction;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional//(Transaction = true)
    public User save(User user) {
        Role role = roleRepository.findById(1).orElse(new Role());
        user.setRole(role);
        User userNew = userRepository.save(user);
        System.out.println(" ***" + userNew);
        return userRepository.save(user);
    }


    @Override
    @Transactional
    public List<User> fetchUserList() {
        return (List<User>) userRepository.findAll();
    }


    @Override
    @Transactional
    public User findByName(String nameUser) {
        return userRepository.findByName(nameUser);
//        User user = userRepository.findByName(nameUser);
//        return user;
    }

    @Override
    @Transactional
    public User updateUser(User user, Integer userId) {
        User userDB = userRepository.findById(userId).get();

        if (Objects.nonNull(user.getName()) && !"".equalsIgnoreCase(user.getName())) {
            userDB.setName(user.getName());
        }

        if (Objects.nonNull(user.getSurname()) && !"".equalsIgnoreCase(user.getSurname())) {
            userDB.setSurname(user.getSurname());
        }

        if (Objects.nonNull(user.getLogin()) && !"".equalsIgnoreCase(user.getLogin())) {
            userDB.setLogin(user.getLogin());
        }

        if (Objects.nonNull(user.getPassword()) && !"".equalsIgnoreCase(user.getPassword())) {
            userDB.setPassword(user.getPassword());
        }

        if (Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail())) {
            userDB.setEmail(user.getEmail());
        }

        return userRepository.save(userDB);
    }

    @Override
    @Transactional
    public void deleteUserById(int userId) {
        userRepository.deleteById(userId);
    }

    @Override
    @Transactional
    public Long count() {
        return userRepository.count();
    }
}
