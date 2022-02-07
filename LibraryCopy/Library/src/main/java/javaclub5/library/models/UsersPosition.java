package javaclub5.library.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usersPosition")
public class UsersPosition {

    @Id
    private int id;

    @OneToMany(mappedBy = "users")
    private List<User> users;

    @Override
    public String toString() {
        return "UsersPosition{" +
                "id=" + id +
                ", users=" + users +
                '}';
    }
}