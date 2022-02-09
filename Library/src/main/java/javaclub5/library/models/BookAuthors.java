package javaclub5.library.models;

import javax.persistence.*;

@Entity
@Embeddable
@Table(name = "booksAuthors", schema = "library", catalog = "JavaClubWeb")
public class BookAuthors {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idBook", insertable = false, updatable = false)
    private Book idBook;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAuthor",insertable = false, updatable = false)
    private Author idAuthor;

    public Book getIdBook() {
        return idBook;
    }

    public void setIdBook(Book idBook) {
        this.idBook = idBook;
    }

    public Author getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Author idAuthor) {
        this.idAuthor = idAuthor;
    }
}
