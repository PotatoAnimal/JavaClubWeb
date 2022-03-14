package javaclub5.library.dto;

import javaclub5.library.models.Author;

import javax.persistence.Column;
import java.time.LocalDate;

public class NewAuthorDTO {
    private int id;
    private String name;
    private String birthDay;
    private String surname;

    public NewAuthorDTO() {
    }

    public NewAuthorDTO(String name, String birthDay, String surname) {
        this.name = name;
        this.birthDay = birthDay;
        this.surname = surname;
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

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Author convertToAuthor(){
        Author author = new Author();
        author.setBirthDay(LocalDate.parse(this.birthDay));
        author.setName(this.name);
        author.setSurname(this.surname);
        return author;
    }

    @Override
    public String toString() {
        return "NewAuthorDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", surname='" + surname + '\'' +
                '}';
    }
}
