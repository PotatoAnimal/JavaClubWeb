package javaclub5.library.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles", schema = "library", catalog = "JavaClubWeb")
public class Roles {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @OneToMany(mappedBy = "idRole")
    private List<Users> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
