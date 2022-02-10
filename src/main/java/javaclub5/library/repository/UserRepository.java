package javaclub5.library.repository;

import javaclub5.library.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Integer> {
}
