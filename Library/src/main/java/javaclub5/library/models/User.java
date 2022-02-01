package javaclub5.library.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private String email;


    @ManyToOne
    @JoinColumn(name = "position")
    private UsersPosition usersPosition;

    @Column
    private LocalDate birthDate;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", usersPosition=" + usersPosition +
                ", birthDate=" + birthDate +
                '}';
    }
}
