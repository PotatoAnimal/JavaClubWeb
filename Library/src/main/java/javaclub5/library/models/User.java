package javaclub5.library.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column
    private int id;

    @Column
    private String Name;

    @Column
    private String login;

    @Column
    private String password;
}
