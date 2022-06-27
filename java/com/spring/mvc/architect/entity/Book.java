package com.spring.mvc.architect.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="books")
@Component
public class Book extends Library_document {
    @Column(name = "Publishing_house")
    private String Publishing_house;

    public Book(String label, String author, String publishing_house, String image) {
        super.setLabel(label);
        super.setAuthor(author);
        super.setID(ID);
        super.setImage(image);
        Publishing_house = publishing_house;
    }

    public Book() {
    }

    public String getPublishing_house() {
        return Publishing_house;
    }

    @Override
    public String Show_document() {
        return "";
    }

    public void setPublishing_house(String publishing_house) {
        Publishing_house = publishing_house;
    }
}
