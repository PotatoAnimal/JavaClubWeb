package javaclub5.library.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "log_book", schema = "library", catalog = "JavaClubWeb")
public class LogBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_book", insertable = false,updatable = false)
    private Book idBook;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private User idUser;
    @Column(name = "data_out")
    private LocalDate dataOut;
    @Column(name = "date_in")
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
