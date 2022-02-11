package javaclub5.library.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books", schema = "library", catalog = "JavaClubWeb")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;
    @Column(length = 35)
    private String title;
    @Column(name = "year_production")
    private int yearProduction;
    //#todo Popova - clarify.
    @Column(name = "id_author")
    private int idAuthor;

    @ManyToOne
    @JoinColumn(name = "id_author", insertable = false,updatable = false)
    private Author author;

    @ManyToMany
    @JoinTable(
            name = "log_book",
            joinColumns = @JoinColumn(name = "id_book"),
            inverseJoinColumns = @JoinColumn(name = "id_user")
    )
    private List<User> users;


    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book() {

    }

//    public List<Author> getAuthors() {
//        return authors;
//    }
//
//    public void setAuthors(List<Author> authors) {
//        this.authors = authors;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYearProduction() {
        return yearProduction;
    }

    public void setYearProduction(Integer yearProduction) {
        this.yearProduction = yearProduction;
    }

    public Integer getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Integer idAuthor) {
        this.idAuthor = idAuthor;
    }

//
//    public List<Author> getAuthors() {
//        return authors;
//    }
//
//    public void setAuthors(List<Author> authors) {
//        this.authors = authors;
//    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", yearProduction=" + yearProduction +
                ", idAuthor=" + idAuthor +
                ", author=" +
                '}';
    }
}
