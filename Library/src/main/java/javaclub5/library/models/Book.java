package javaclub5.library.models;

import javax.persistence.*;
import java.util.List;

@Entity
//@Table(name = "books")
@Table(name = "books", schema = "library", catalog = "library")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "yearProduction")
    private int yearProduction;

    @ManyToOne
    @JoinColumn(name = "idAuthor")
    private Author author;

    @ManyToMany
    @JoinTable(
            name = "logBook",
            joinColumns = @JoinColumn(name = "idBook"),
            inverseJoinColumns = @JoinColumn(name = "idUser")
    )
    private List<User> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<User> getReaders() {
        return users;
    }

    public void setReaders(List<User> readers) {
        this.users = readers;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book [" + id + " " + title + " " + author.getName() + "]";
    }
}
