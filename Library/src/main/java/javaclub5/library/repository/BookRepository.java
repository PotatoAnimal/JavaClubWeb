package javaclub5.library.repository;

import javaclub5.library.models.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book,Integer> {

    @Query("SELECT b FROM Book b WHERE b.title = :title")
    Book findBookByTitle(@Param("title") String title);

    void deleteBookById(int bookId);

    @Query("SELECT b FROM Book b join Author a on b.id = a.id where a.name = :authorName")
    Book findBookByAuthor(@Param("authorName") String authorName);
}
