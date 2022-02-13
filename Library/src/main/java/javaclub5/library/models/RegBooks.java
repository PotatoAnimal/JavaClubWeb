package javaclub5.library.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "reg_books", schema = "library", catalog = "JavaClubWeb")
public class RegBooks {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "amount", nullable = true)
    private int count;
    @Column(name = "price", nullable = true)
    private int price;
    @Column(name = "donated", nullable = true)
    private boolean donated;
    @Column(name = "operations", nullable = false)
    private int operations;
    @ManyToOne
    @JoinColumn(name = "id_book")
    private Book book;

    @Override
    public String toString() {
        return "RegBooks{" +
                "id=" + id +
                ", count=" + count +
                ", price=" + price +
                ", donated=" + donated +
                ", operations=" + operations +
                ", book=" + book +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegBooks)) return false;
        RegBooks regBooks = (RegBooks) o;
        return getId() == regBooks.getId() && getCount() == regBooks.getCount() && getPrice() == regBooks.getPrice() && isDonated() == regBooks.isDonated() && getOperations() == regBooks.getOperations() && Objects.equals(getBook(), regBooks.getBook());
    }



    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCount(), getPrice(), isDonated(), getOperations(), getBook());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isDonated() {
        return donated;
    }

    public void setDonated(boolean donated) {
        this.donated = donated;
    }

    public int getOperations() {
        return operations;
    }

    public void setOperations(int operations) {
        this.operations = operations;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
