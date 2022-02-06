package javaclub5.library.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles", schema = "library", catalog = "JavaClubWeb")
public class Role {
    @Id
    @Column(name = "id", nullable = false)
    private int idRole;
    @OneToMany(mappedBy = "role")
    private List<User> users;

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
        return "Roles{" +
                "idRole=" + idRole +
                ", users=" + users +
                '}';
    }
}
