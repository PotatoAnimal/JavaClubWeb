package javaclub5.library.models;

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



    @Override
    public String toString() {
        return "Roles{" +
                "idRole=" + idRole +
                ", users=" + name +
                '}';
    }
}
