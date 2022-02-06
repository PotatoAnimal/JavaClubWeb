package javaclub.library.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    //@Size(max = 20, min = 3, message ={"user.name.invalid"})
    private String name;

    @Column(name = "login")
    private String login;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "idRole")
    private Role role;

    //@Column (name = "birthDate" , updatable = false )
    @Column (name = "birthDate")
    private LocalDateTime birthDate ;

    @Column(name = "surname")
    private String surname;

    @ManyToMany
    @JoinTable(
            name = "logBook",
            joinColumns = @JoinColumn(name = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "idBook")
    )
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

    public User() {
    }

    @Override
    public String toString() {
        String allBooks = "";
        for (Book o : books) {
            allBooks += o.getTitle() + " ";
        }
        return "Reader [" + id + " " + name + ": " + allBooks + "]";
    }
}
