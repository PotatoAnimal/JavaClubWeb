package javaclub5.library.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "library", catalog = "JavaClubWeb")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = true, length = 20)
    private String name;
    @Column(name = "login", nullable = true, length = 20)
    private String login;
    @Column(name = "password", nullable = true, length = 20)
    private String password;
    @Column(name = "email", nullable = true, length = 30)
    private String email;
    @ManyToOne
    @JoinColumn(name ="roles.id", referencedColumnName="id")
    private Role role;
    @Column(name = "birthday", nullable = true)
    private Date birthday;
    @Column(name = "surname", nullable = true, length = 20)
    private String surname;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User users = (User) o;
        return getId() == users.getId() && Objects.equals(getName(), users.getName()) && Objects.equals(getLogin(), users.getLogin()) && Objects.equals(getPassword(), users.getPassword()) && Objects.equals(getEmail(), users.getEmail()) && Objects.equals(getBirthday(), users.getBirthday()) && Objects.equals(getSurname(), users.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getLogin(), getPassword(), getEmail(), getBirthday(), getSurname());
    }

    @Override
    public String toString() {
        return "\nUsers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
