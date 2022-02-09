package javaclub5.library.models;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "books", schema = "library", catalog = "JavaClubWeb")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(length = 35)
    private String title;
    @Column
    private Integer yearProduction;
    //#todo Popova - clarify.
    @Column
    private Integer idAuthor;

//    @ManyToOne
//    @JoinColumn(name = "idAuthor")
//    private Author author;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "booksauthors",
            schema = "library",
            joinColumns = {@JoinColumn(name = "idBook")},
            inverseJoinColumns = {@JoinColumn(name = "idAuthor")}
    )
    private List<Author> authors;

    public Book() {

    }

//    public Author getAuthor() {
//        return author;
//    }

//    public void setAuthor(Author author) {
//        this.author = author;
//    }

    public Book(List<Author> authors) {
        this.authors = authors;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

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
