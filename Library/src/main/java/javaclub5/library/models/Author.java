package javaclub5.library.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
//@Table(name = "authors")
@Table(name = "authors", schema = "library", catalog = "library")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "birthDay")
    private LocalDateTime birthDay ;

    @Column(name = "surname")
    private String surname;

    @OneToMany(mappedBy = "author")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Book> books;

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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public LocalDateTime getBirthDay() {return birthDay;}

    public void setBirthDay(LocalDateTime birthDay) {this.birthDay = birthDay;}

    public String getSurname() {return surname;}

    public void setSurname(String surname) {this.surname = surname;}

    public Author() {
    }

    @Override
    public String toString() {
        String allBooks = "";
        for (Book o : books) {
            allBooks += o.getTitle() + " ";
        }
        return "Author [" + id + " " + name + " " + allBooks + "]";
    }
}
