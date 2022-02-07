package javaclub5.library.models;

import javax.persistence.*;
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

    public Book() {
    }

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "booksAuthors",
            schema = "library",
            joinColumns = {@JoinColumn(name = "idBook")},
            inverseJoinColumns = {@JoinColumn(name = "idAuthor")}
    )
    private List<Author> authors;

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

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", yearProduction=" + yearProduction +
                ", idAuthor=" + idAuthor +
                '}';
    }
}
