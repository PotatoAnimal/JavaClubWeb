package javaclub5.library.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "logBook", schema = "library", catalog = "JavaClubWeb")
public class LogBook {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "idBook", nullable = true)
    private int idBook;
    @Column(name = "idUser", nullable = true)
    private int idUser;
    @Column(name = "dataOut",nullable = true)
    private Date dataOut;
    @Column(name = "dateIn", nullable = true)
    private Date dateIn;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Date getDataOut() {
        return dataOut;
    }

    public void setDataOut(Date dataOut) {
        this.dataOut = dataOut;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }
}
