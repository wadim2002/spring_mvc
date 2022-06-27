package com.spring.mvc.architect.dao;

import com.spring.mvc.architect.entity.Book;
import com.spring.mvc.architect.entity.myEntity;

import java.util.List;

public interface BookDAO {

    public List<Book> getAllBook();
    public Book getBook(int id);
    public void addBook(Book book);
    public void deleteBook(int id);
}
