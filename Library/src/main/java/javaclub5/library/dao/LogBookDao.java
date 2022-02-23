package javaclub5.library.dao;

import javaclub5.library.models.LogBook;
import javaclub5.library.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class LogBookDao {
    @Autowired
    private SessionFactory sf;
    private List<LogBook> logBooks = new LinkedList<>();

    public LogBookDao() {

    }

    @Transactional
    public List<LogBook> readAll() {
        logBooks = (List<LogBook>) sf.getCurrentSession().createQuery("select lb from LogBook lb " +
                        "left join fetch lb.book b ")
                .list().stream().distinct().collect(Collectors.toList());
        for (LogBook logBook : logBooks) {
            logBook.getBook().getAuthors().stream().distinct().collect(Collectors.toList());
        }
        return logBooks;
    }

    @Transactional
    public void create(LogBook logBook) {
        sf.getCurrentSession().save(logBook);
    }

    @Transactional
    public LogBook readByID(int id) {
        LogBook logBook = sf.getCurrentSession().get(LogBook.class, id);
        return logBook;
    }

    @Transactional
    public void update(LogBook logBook) {
        sf.getCurrentSession().update(logBook);
    }

    @Transactional
    public void delete(LogBook logBook) {
        sf.getCurrentSession().delete(logBook);
    }

    @Transactional
    public List<LogBook> getUserStatistic(User user) {
        List<LogBook> usersLogBooks = (List<LogBook>) sf.getCurrentSession()
                .createQuery("select lb from LogBook lb " +
                        "left join fetch lb.book bk left join fetch bk.Authors where lb.user.id = :Id").setParameter("Id", user.getId())
                .list().stream().distinct().collect(Collectors.toList());
        return usersLogBooks;
    }

    @Transactional
    public long countGivenBooksByPeriod(LocalDate dataFrom, LocalDate dataTo){
        Session session = sf.getCurrentSession();
//        dataFrom=LocalDate.of(2022,1,1);
//        dataTo=LocalDate.of(2022, 1, 5);
        String hqlString = "select count(*) from LogBook as lb " +
                "where lb.dataOut>= :dataFrom and lb.dataOut< :dataTo";
        Query query = session.createQuery(hqlString)
                .setParameter("dataFrom", dataFrom)
                .setParameter("dataTo", dataTo);
        long cntRec = (long)query.uniqueResult();
        return cntRec;
    }

}
