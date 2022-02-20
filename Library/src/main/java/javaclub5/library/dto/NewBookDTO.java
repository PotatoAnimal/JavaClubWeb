package javaclub5.library.dto;

import javaclub5.library.models.Book;

public class NewBookDTO {
    private int id;
    private String title;
    private int yearProduction;
    private int amount;
    private int price;
    private String authorSurname;
    private String authorName;

    public NewBookDTO() {
    }

    public NewBookDTO(String title, int yearProduction, int amount, int price, String surname, String name) {
        this.title = title;
        this.yearProduction = yearProduction;
        this.amount = amount;
        this.price = price;
        this.authorSurname = surname;
        this.authorName = name;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearProduction() {
        return yearProduction;
    }

    public void setYearProduction(int yearProduction) {
        this.yearProduction = yearProduction;
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

    public Book convertToBook(){
        Book book = new Book();
        book.setTitle(this.title);
        book.setYearProduction(this.yearProduction);
        return book; //  need to finish with (Register book with copies)
    }

    @Override
    public String toString() {
        return "NewBookDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", yearProduction=" + yearProduction +
                ", amount=" + amount +
                ", price=" + price +
                ", surname='" + authorSurname + '\'' +
                ", name='" + authorName + '\'' +
                '}';
    }
}
