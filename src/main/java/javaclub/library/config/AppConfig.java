package javaclub.library.config;

import javaclub.library.model.Author;
import javaclub.library.model.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    //<bean id="Author" class="javaclub.library.entities.Author"/>
    @Bean
    public Author author(){
        Author author = new Author();
        return author;
    }
    @Bean
    public Book book(){
        Book book = new Book();
        book.setAuthor(author());
        return book;
    }
}
