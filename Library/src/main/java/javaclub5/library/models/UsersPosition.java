package javaclub5.library.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UsersPosition {

    @Id
    private int id;

    @Column
    private String position;

    @OneToMany(mappedBy = "users")
    private List<User> users;

    @Override
    public String toString() {
        return "UsersPosition{" +
                "id=" + id +
                ", position='" + position + '\'' +
                ", users=" + users +
                '}';
    }
}
