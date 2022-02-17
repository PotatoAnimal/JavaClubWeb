package javaclub5.library.models;

import javax.persistence.*;

@Entity
@Table(name = "reg_books", schema = "library", catalog = "JavaClubWeb")
public class RegBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_book", insertable = false, updatable = false)
    private Book book;

    @Column
    private int amount;
    @Column
    private int price;
    @Column
    private boolean donated;
    @Column
    private int operations;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
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

    @Override
    public String toString() {
        return "RegBook{" +
                "id=" + id +
                ", book=" + book +
                ", count=" + amount +
                ", price=" + price +
                ", donated=" + donated +
                ", operations=" + operations +
                '}';
    }
}
