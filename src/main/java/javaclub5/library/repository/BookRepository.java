package javaclub5.library.repository;

import javaclub5.library.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.kotlin.CoroutineCrudRepository;

public interface BookRepository extends CoroutineCrudRepository <Book, Integer> {
}
