package javaclub5.library.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Embeddable
@Table(name = "booksAuthors", schema = "library", catalog = "javatest")
public class BookAuthors {


//    @ManyToOne (optional=false, cascade=CascadeType.ALL)
//    @JoinColumn (name="idBook")
//    private Book bookId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idBook", insertable = false, updatable = false)
    private Book idBook;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAuthor", insertable = false, updatable = false)
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
