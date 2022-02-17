package javaclub5.library.service;

import javaclub5.library.dao.LogBookDAO;
import javaclub5.library.models.LogBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LogBookServiceImp implements LogBookService {

    @Autowired
    private LogBookDAO logBookDAO;

    @Override
    @Transactional
    public void delete(LogBook logBook) {
        this.logBookDAO.delete(logBook);
    }

    @Override
    @Transactional
    public void update(LogBook logBook) {
        this.logBookDAO.update(logBook);
    }

    @Override
    @Transactional
    public LogBook readByID(int id) {
        return this.logBookDAO.readByID(id);
    }

    @Override
    @Transactional
    public void create(LogBook logBook) {
        this.logBookDAO.create(logBook);
    }

    @Override
    @Transactional
    public List<LogBook> readAll() {
        return this.logBookDAO.readAll();
    }
}
