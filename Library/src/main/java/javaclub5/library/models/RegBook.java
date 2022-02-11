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
    private int count;
    @Column
    private int price;
    @Column
    private boolean donated;
    @Column
    private int operations;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
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

    @Override
    public String toString() {
        return "RegBook{" +
                "id=" + id +
                ", book=" + book +
                ", count=" + count +
                ", price=" + price +
                ", donated=" + donated +
                ", operations=" + operations +
                '}';
    }
}
