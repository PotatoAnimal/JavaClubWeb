package javaclub5.library.service;

import javaclub5.library.models.User;
import javaclub5.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchUserList() {
        return (List<User>) userRepository.findAll();
    }

    @Override
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
    public Object deleteUserById(Integer userId) {
        userRepository.deleteById(userId);
        return null;
    }

    @Override
    public Long count(){
        return userRepository.count();
    }
}
