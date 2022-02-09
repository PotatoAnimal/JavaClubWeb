package javaclub5.library.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
//@Table(name = "logBook")
@Table(name = "logBook", schema = "library", catalog = "library")
public class LogBook {
    @Embeddable
    public static class Id implements Serializable {
        @Column(name = "idBook")
        int idBook;

        @Column(name = "idUser")
        int idUser;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Id id = (Id) o;
            return idUser == id.idUser &&
                    idBook == id.idBook;
        }

        @Override
        public int hashCode() {
            return idUser + idBook;
        }
    }

    @EmbeddedId
    Id id;

    @ManyToOne
    @JoinColumn(name = "idUser")
    User user;

    @ManyToOne
    @JoinColumn(name = "idBook")
    Book book;

    @Column(name = "score")
    int score;

    @Column(name = "dataOut")
    private LocalDateTime dataOut ;

    @Column(name = "dataIn")
    private LocalDateTime dataIn ;
}
