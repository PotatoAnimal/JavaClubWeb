package javaclub5.library.service;

import javaclub5.library.models.LogBook;

import java.util.List;

public interface LogBookService {
    public void delete(LogBook logBook);
    public void update(LogBook logBook);
    public LogBook readByID(int id);
    public void create(LogBook logBook);
    public List<LogBook> readAll();
}
