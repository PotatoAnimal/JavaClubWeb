package javaclub5.library.repository;

import javaclub5.library.models.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    void deleteById(int userId);

    @Query("SELECT u from User u WHERE u.name = :name")
    User findByName(@Param("name") String userName);

//    @Modifying
//    @Query(value = "insert into library.users (surname, name, email,login,password)" +
//            " VALUES (:surname, :name, :email,:login,:password)", nativeQuery = true)
//    @Transactional
//    void addUser(@Param("surname") String surname, @Param("name") String name, @Param("email") String email,
//                  @Param("login") String login, @Param("password") String password);
}
