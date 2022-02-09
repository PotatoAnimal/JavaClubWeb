package javaclub5.library.models;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "logBook", schema = "library", catalog = "JavaClubWeb")
public class LogBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idBook", insertable = false,updatable = false)
    private Book idBook;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser", insertable = false, updatable = false)
    private User idUser;
    @Column(name = "dataOut")
    private LocalDate dataOut;
    @Column(name = "dateIn")
    private LocalDate dateIn;

    public Book getIdBook() {
        return idBook;
    }

    public void setIdBook(Book idBook) {
        this.idBook = idBook;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataOut() {
        return dataOut;
    }

    public void setDataOut(LocalDate dataOut) {
        this.dataOut = dataOut;
    }

    public LocalDate getDateIn() {
        return dateIn;
    }

    public void setDateIn(LocalDate dateIn) {
        this.dateIn = dateIn;
    }

    @Override
    public String toString() {
        return "LogBook{" +
                "id=" + id +
                ", idBook=" + idBook +
                ", idUser=" + idUser +
                ", dataOut=" + dataOut +
                ", dateIn=" + dateIn +
                '}';
    }
}
