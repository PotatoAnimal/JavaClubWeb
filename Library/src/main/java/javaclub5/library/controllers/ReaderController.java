package javaclub5.library.controllers;

import javaclub5.library.dao.BookDao;
import javaclub5.library.dao.LogBookDao;
import javaclub5.library.dao.UserDao;
import javaclub5.library.models.Book;
import javaclub5.library.models.LogBook;
import javaclub5.library.models.User;
import javaclub5.library.services.ReaderService;
import javaclub5.library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@Controller
public class ReaderController {
    @Autowired
    private ReaderService userService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private LogBookDao logBookDao;
    @Autowired
    private BookDao bookDao;

    /**
     * @param id Reader ID
     * @param model
     * @return main menu Reader
     */
    @GetMapping("/readers/{id}")
    public String goToReader(@PathVariable("id") int id, Model model) {
        model.addAttribute("books", userService.getBookList());
        model.addAttribute("userService", userService);
        model.addAttribute("user", userDao.readByID(id));
        model.addAttribute("id", id);
        return "readers/readerbookslist";
    }

    /**
     * @param id Reader ID
     * @param model
     * @return edit menu of Reader
     */
    @PostMapping("/users/{id}")
    public String editReader(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDao.readByID(id));
        model.addAttribute("id", id);
        return "readers/readersedit";
    }

    /**
     *
     * @param id Reader ID
     * @param user
     * @return updated Reader menu after reader edit
     */
    @GetMapping("/reader/{id}/update")
    public String update(@PathVariable("id") int id,
                         @ModelAttribute("user") User user) {
        User oldUser = userDao.readByID(id);
        oldUser.setName(user.getName());
        oldUser.setSurname(user.getSurname());
        oldUser.setBirthday(user.getBirthday());
        userDao.update(oldUser);
        return "redirect: /readers/{id} ";
    }

    /**
     * @param id Reader ID
     * @param model
     * @return Reader statistics
     */
    @PostMapping("/readers/{id}/stat")
    public String getStatistics(@PathVariable("id") int id, Model model) {
        User user = userDao.readByID(id);
        model.addAttribute("userLogBook", logBookDao.getUserStatistic(user));
        model.addAttribute("user", user);
        model.addAttribute("id", id);
        return "readers/readerstat";
    }

    /**
     * @param id Reader ID
     * @param idBook Book ID
     * @param model
     * @return redirect to List of Odered Books
     */
    @PostMapping("/readers/{id}/orderbook/{idBook}")
    public String orderBook(@PathVariable("id") int id,
                            @PathVariable("idBook") int idBook,
                            Model model) {
        Book book = bookDao.readByID(idBook);
        User user = userDao.readByID(id);
        LogBook logBook = new LogBook();
        logBook.setBook(book);
        logBook.setUser(user);
        logBookDao.create(logBook);
        model.addAttribute("user",user);
        model.addAttribute("id", id);
        return "redirect:/readers/{id}/orderedbook";
    }


    @GetMapping("/readers/{id}/orderedbook")
    public String showOrderedBooks(@PathVariable("id") int id, Model model) {
        User user = userDao.readByID(id);
        model.addAttribute("logBooks", userService.getOrderedBooks(userDao.readByID(id)));
        model.addAttribute("user", user);
        model.addAttribute("id", id);
        return "readers/readerorder";
    }


   /* @GetMapping("/readers/books")
    public String findAllBooks(Model model) {
        model.addAttribute("books", userService.getBookList());
        model.addAttribute("userService", userService);
        return "readers/readerbookslist";
    }*/


    /**
     * @param title Title of Book
     * @param id Reader ID
     * @param model
     * @return sorted book title Reader's menu
     */
    @GetMapping("/readers/{id}/booksbytitle")
    public String findBookByTitle(@RequestParam("title") String title,@PathVariable("id") int id, Model model) {
        model.addAttribute("books", userService.getBookByTitle(title));
        model.addAttribute("userService", userService);
        model.addAttribute("user", userDao.readByID(id));
        model.addAttribute("id", id);
        return "readers/readerbookslist";
    }

    /**
     * @param name Author's name of Book
     * @param id Reader ID
     * @param model
     * @return sorted book Author Reader's menu
     */
    @GetMapping("/readers/{id}/booksbyauthor")
    public String findBookByAuthor(@PathVariable("id") int id, @RequestParam("name") String name,
                                   @RequestParam("surname") String surname, Model model) {
        model.addAttribute("books", userService.getBookByAuthor(name, surname));
        model.addAttribute("userService", userService);
        model.addAttribute("user", userDao.readByID(id));
        model.addAttribute("id", id);
        return "readers/readerbookslist";
    }

    /**
     *
     * @param id Reader ID
     * @param firstDate
     * @param secondDate
     * @param model
     * @return return popular book between firstDate and secondDate
     */
    @GetMapping("/readers/{id}/popularbooks")
    public String findPopularBooks(@PathVariable("id") int id, @RequestParam("firstDate")
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate firstDate,
                                   @RequestParam("secondDate")
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate secondDate,
                                   Model model) {
        model.addAttribute("books",
                userService.findPopularBook(userService.getBookByDate(firstDate, secondDate)));
        model.addAttribute("userService", userService);
        model.addAttribute("user", userDao.readByID(id));
        model.addAttribute("id", id);
        return "readers/readerbookslist";
    }
}
