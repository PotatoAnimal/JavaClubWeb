package javaclub5.library.repository;

import javaclub5.library.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    void deleteById(int userId);

    @Query("SELECT u from User u WHERE u.name = :name")
    User findByName(@Param("name") String userName);

}
