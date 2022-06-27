package com.spring.mvc.architect.controller;

import com.spring.mvc.architect.dao.BookDAOimpl;
import com.spring.mvc.architect.dao.myEntityDAO;
import com.spring.mvc.architect.entity.Book;
import com.spring.mvc.architect.entity.myEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ControllerBook {
    @Autowired
    private BookDAOimpl BookDAO;

    @RequestMapping(path = "/")
    public String showAllBooks(Model model){

        List<Book> allBooks = BookDAO.getAllBook();
        // Добавили результаты во вью
        model.addAttribute("allbooks", allBooks);
        return "ShowAllBooks";
    }
    @RequestMapping(path = "/showBook")
    public String showBook(@RequestParam("id") int id, Model model){

        Book book = BookDAO.getBook(id);
        // Добавили результаты во вью
        model.addAttribute("onebook", book);
        System.out.println("Получили ID книги" + book.getID());
        return "ShowBook";
    }

    @RequestMapping(path = "/deleteBook")
    public String deleteBook(@RequestParam("id") int id){

        BookDAO.deleteBook(id);
        return "redirect:/";
    }
    @RequestMapping(path = "/addBook")
    //public String addBooks(@ModelAttribute("newbook") Model model){
    public String addBooks(Model model){

        //Book book = new Book((String) model.getAttribute("label") , (String)model.getAttribute("author"), (String)model.getAttribute("publishing_house"), (String)model.getAttribute("image"));
        Book book = new Book();
        model.addAttribute("book", book);
        //BookDAO.addBook(book);
        return "AddBook";
    }

    @RequestMapping(path = "/saveBook")
    public String saveBooks(@ModelAttribute("newbook") Book book){
        BookDAO.addBook(book);
        return "redirect:/";
    }
}
