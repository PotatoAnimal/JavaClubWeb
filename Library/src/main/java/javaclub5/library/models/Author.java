package javaclub5.library.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "authors", schema = "library", catalog = "JavaClubWeb")
public class Author {
    @Id
    @Column(nullable = false)
    private int id;
    @Column(length = 20)
    private String name;
    @Column
    private Date birthDay;
    @Column(length = 20)
    private String surname;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getBirthDay());
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

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
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
                '}';
    }
}
