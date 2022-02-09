package javaclub5.library.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "roles", schema = "library", catalog = "JavaClubWeb")
public class Role {
    @Id
    @Column(name = "id", nullable = false)
    private int idRole;
    @Column
    private String name;

    @OneToMany(mappedBy = "role")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return idRole;
    }

    public void setId(int id) {
        this.idRole = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return name;
    }
}
