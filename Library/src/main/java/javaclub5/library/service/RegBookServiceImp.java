package javaclub5.library.service;

import javaclub5.library.dao.RegBookDAO;
import javaclub5.library.models.RegBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RegBookServiceImp implements RegBookService {
    @Autowired
    private RegBookDAO regBookDAO;

    @Override
    @Transactional
    public List<RegBook> readAll() {
        return this.regBookDAO.readAll();
    }

    @Override
    @Transactional
    public void create(RegBook regBook) {
        this.regBookDAO.create(regBook);
    }

    @Override
    @Transactional
    public RegBook readByID(int id) {
        return this.regBookDAO.readByID(id);
    }

    @Override
    @Transactional
    public void update(RegBook regBook) {
        this.regBookDAO.update(regBook);
    }
}
