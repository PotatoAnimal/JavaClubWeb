package javaclub5.library.dto;

import javaclub5.library.models.Book;
import javaclub5.library.models.RegBooks;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class RegBookDTO {
    private int id;
    private int amount;
    private int price;
    private boolean donated;
    private int operations;
    private Book book;

    public RegBookDTO() {
    }

    public RegBookDTO(int amount, int price, boolean donated, int operations, Book book) {
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

    public void setAmount(int amount) {
        this.amount = amount;
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

    public RegBooks convertToRegBook(){
        RegBooks regBooks = new RegBooks();
          regBooks.setAmount(this.amount);
          regBooks.setDonated(this.donated);
          regBooks.setOperations(this.operations);
          regBooks.setPrice(this.price);
          return regBooks;
    }
}
