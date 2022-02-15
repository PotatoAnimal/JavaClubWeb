package javaclub5.library.models;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "log_book", schema = "library", catalog = "JavaClubWeb")
public class LogBook {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "data_out", nullable = true)
    private LocalDate dataOut;
    @Column(name = "date_in", nullable = true)
    private LocalDate dateIn;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @ManyToOne
    @JoinColumn(name = "id_book")
    private Book book;

    @Override
    public String toString() {
        return "LogBook{" +
                "id=" + id +
                ", dataOut=" + dataOut +
                ", dateIn=" + dateIn +
                ", user=" + user +
                ", book=" + book +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogBook)) return false;
        LogBook logBook = (LogBook) o;
        return getId() == logBook.getId() && Objects.equals(getDataOut(), logBook.getDataOut()) && Objects.equals(getDateIn(), logBook.getDateIn()) && Objects.equals(getUser(), logBook.getUser()) && Objects.equals(getBook(), logBook.getBook());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDataOut(), getDateIn(), getUser(), getBook());
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
