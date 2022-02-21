package javaclub5.library.dto;

import javaclub5.library.models.Role;
import javaclub5.library.models.User;

import java.time.LocalDate;
import java.util.Objects;

public class UserDTO {

    private int id;
    private String name;
    private String login;
    private String password;
    private String email;
    private String birthday;
    private String surname;
    private boolean isreader;


    public UserDTO() {
    }

    public UserDTO(String name, String login, String password, String email, String birthday, String surname, boolean isReader) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.birthday = birthday;
        this.surname = surname;
        this.isreader = isReader;
    }

    public boolean isIsreader() {
        return isreader;
    }

    public void setIsreader(boolean isreader) {
        this.isreader = isreader;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public User convertToUser() {
        User user = new User();
        user.setName(this.name);
        user.setSurname(this.surname);
        user.setEmail(this.email);
        user.setLogin(this.login);
        user.setPassword(this.password);
        user.setBirthday(LocalDate.parse(this.birthday));
        return user;
    }

    public Role convertToRole() {
        Role role = new Role();
        if(isreader) {
            role.setId(2);
        } else {
            role.setId(1);
        }
        return role;
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
        return "\nUsers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", surname='" + surname + '\'' +
                '}';
    }
}
