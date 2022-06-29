package com.spring.mvc.architect.controller;


import com.spring.mvc.architect.dao.BookDAO;
import com.spring.mvc.architect.entity.Book;
import com.spring.mvc.architect.entity.Employee;
import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTControllerBOOK {

    @Autowired
    private BookDAO bookDAO;

    @GetMapping("/allBooks")
    public List<Book> showAllEmployees(){
        List<Book> allBook = bookDAO.getAllBook();
        return allBook;
    }
}
