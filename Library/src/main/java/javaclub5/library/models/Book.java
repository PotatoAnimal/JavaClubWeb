package javaclub5.library.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "books", schema = "library", catalog = "JavaClubWeb")
public class Book {

    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "title", nullable = true, length = 50)
    private String title;
    @Column(name = "year_production", nullable = true)
    private int yearProduction;
    @ManyToMany()
    @JoinTable(name = "books_authors", schema = "library", catalog = "JavaClubWeb",
    joinColumns = @JoinColumn(name = "id_book"),
    inverseJoinColumns = @JoinColumn(name = "id_author"))
    private List<Author> Authors;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", yearProduction=" + yearProduction +
                ", Authors=" + Authors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getId() == book.getId() && getYearProduction() == book.getYearProduction() && Objects.equals(getTitle(), book.getTitle())  && Objects.equals(getAuthors(), book.getAuthors());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getYearProduction(), getAuthors());
    }

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

    public int getYearProduction() {
        return yearProduction;
    }

    public void setYearProduction(int yearProduction) {
        this.yearProduction = yearProduction;
    }

    public List<Author> getAuthors() {
        return Authors;
    }

    public void setAuthors(List<Author> coAuthors) {
        this.Authors = coAuthors;
    }
}
