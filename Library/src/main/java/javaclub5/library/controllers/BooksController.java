package javaclub5.library.controllers;

import javaclub5.library.models.Book;
import javaclub5.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BooksController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String listBooks(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("listBooks", this.bookService.listBooks());
        return "books/list";
    }

    //For add and update book both
    @RequestMapping(value = "books/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book a){
        if (a.getId() ==0){
            //new book, add him
            this.bookService.addBook(a);
        }else{
            //existing book, call update
            this.bookService.updateBook(a);
        }

        return "redirect:/books";
    }

    @RequestMapping("/books/remove/{id}")
    public String removeBook(@PathVariable("id") int id){
        this.bookService.removeBook(id);
        return "redirect:/books";
    }

    @RequestMapping("/books/edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        model.addAttribute("book", this.bookService.getBookById(id));
        model.addAttribute("listBooks", this.bookService.listBooks());
        return "book";
    }
}
