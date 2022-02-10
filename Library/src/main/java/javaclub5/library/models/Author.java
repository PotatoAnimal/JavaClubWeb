package javaclub5.library.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

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

    @Column(name = "birthday")
    private LocalDate birthDay ;

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

    public LocalDate getBirthDay() {return birthDay;}

    public void setBirthDay(LocalDate birthDay) {this.birthDay = birthDay;}

    public String getSurname() {return surname;}

    public void setSurname(String surname) {this.surname = surname;}

    public Author() {
    }

    @Override
    public String toString() {
//        String allBooks = "";
//        for (Book o : books) {
//            allBooks += o.getTitle() + " ";
//        }
//        return "Author [" + id + " " + name + " " + allBooks + "]";
        return this.surname + " " + this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id && Objects.equals(name, author.name) && Objects.equals(birthDay, author.birthDay) && Objects.equals(surname, author.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthDay, surname);
    }
}
