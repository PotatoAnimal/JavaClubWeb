package javaclub5.library.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "reg_books", schema = "library", catalog = "JavaClubWeb")
public class RegBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "amount", nullable = true)
    private int amount;
    @Column(name = "price", nullable = true)
    private int price;
    @Column(name = "donated", nullable = true)
    private boolean donated;
    @Column(name = "operations", nullable = false)
    private int operations;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_book")
    private Book book;

    public RegBooks() {
    }

    public RegBooks(int amount, int price, boolean donated, int operations, Book book) {
        this.amount = amount;
        this.price = price;
        this.donated = donated;
        this.operations = operations;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int count) {
        this.amount = count;
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

    @Override
    public String toString() {
        return "RegBooks{" +
                "id=" + id +
                ", amount=" + amount +
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
        return getId() == regBooks.getId() && getAmount() == regBooks.getAmount() && getPrice() == regBooks.getPrice() && isDonated() == regBooks.isDonated() && getOperations() == regBooks.getOperations() && Objects.equals(getBook(), regBooks.getBook());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAmount(), getPrice(), isDonated(), getOperations(), getBook());
    }

}
