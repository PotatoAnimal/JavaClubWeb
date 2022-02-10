package javaclub5.library.repository;

import javaclub5.library.models.Role;
import org.springframework.data.repository.kotlin.CoroutineCrudRepository;

public interface RoleRepository extends CoroutineCrudRepository <Role, Integer> {
}
