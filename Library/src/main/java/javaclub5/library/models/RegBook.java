package javaclub5.library.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "regBooks", schema = "library", catalog = "JavaClubWeb")
public class RegBook {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "idBook", nullable = true)
    private int idBook;
    @Column(name = "count", nullable = true)
    private int count;
    @Column(name = "price", nullable = true)
    private int price;
    @Column(name = "donated", nullable = true)
    private int donated;
    @Column(name = "operations", nullable = true)
    private int operations;


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

    public int getDonated() {
        return donated;
    }

    public void setDonated(int donated) {
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
                ", idBook=" + idBook +
                ", count=" + count +
                ", price=" + price +
                ", donated=" + donated +
                ", operations=" + operations +
                '}';
    }
}
