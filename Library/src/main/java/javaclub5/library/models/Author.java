package javaclub5.library.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "authors", schema = "library", catalog = "JavaClubWeb")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;
    @Column(length = 20)
    private String name;
    @Column(name = "birthDay")
    private LocalDate birthDay;
    @Column(length = 20)
    private String surname;

//    @OneToMany(mappedBy = "author")
//    @Cascade(org.hibernate.annotations.CascadeType.ALL)
//    private List<Book> books;

    @ManyToMany(mappedBy = "authors")
    private List<Book> booksAuthors;

    public Author() {
    }

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getBirthDay());
    }

//    public List<Book> getBooks() {
//        return books;
//    }
//
//    public void setBooks(List<Book> books) {
//        this.books = books;
//    }

    public List<Book> getBooksAuthors() {
        return booksAuthors;
    }

    public void setBooksAuthors(List<Book> booksAuthors) {
        this.booksAuthors = booksAuthors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", surname='" + surname + '\'' +
                ", books=" +
                '}';
    }
}
