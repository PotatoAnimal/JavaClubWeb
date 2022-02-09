package javaclub5.library.models;

import javax.persistence.*;

@Entity
@Embeddable
@Table(name = "booksAuthors", schema = "library", catalog = "JavaClubWeb")
public class BookAuthors {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idBook", insertable = false, updatable = false)
    private Book idBook;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAuthor")
    private Author idAuthor;

}
