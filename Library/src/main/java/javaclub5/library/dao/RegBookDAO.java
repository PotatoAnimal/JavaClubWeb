package javaclub5.library.dao;

import javaclub5.library.models.RegBook;

import java.util.List;

public interface RegBookDAO {

    public List<RegBook> readAll();
    public void create(RegBook regBook);
    public RegBook readByID(int id);
    public void update(RegBook regBook);
}
