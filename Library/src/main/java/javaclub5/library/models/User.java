package javaclub5.library.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "library", catalog = "JavaClubWeb")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = true, length = 20)
    private String name;
    @Column(name = "login", nullable = true, length = 20)
    private String login;
    @Column(name = "password", nullable = true)
    private String password;
    @Column(name = "email", nullable = true, length = 30)
    private String email;
    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;
    @Column(name = "birthday", nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    @Column(name = "surname", nullable = true, length = 20)
    private String surname;

    public String userToString(User user) {
        return name + " " + surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User users = (User) o;
        return getId() == users.getId() && Objects.equals(getName(), users.getName()) && Objects.equals(getLogin(),
                users.getLogin()) && Objects.equals(getPassword(), users.getPassword()) && Objects.equals(getEmail(),
                users.getEmail()) && Objects.equals(getBirthday(), users.getBirthday()) && Objects.equals(getSurname(), users.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getLogin(), getPassword(), getEmail(), getBirthday(), getSurname());
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role.getName() +
                ", birthday=" + birthday +
                ", surname='" + surname + '\'' +
                '}';
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role idRole) {
        this.role = idRole;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
