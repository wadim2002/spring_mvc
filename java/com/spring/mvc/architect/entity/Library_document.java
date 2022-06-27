package com.spring.mvc.architect.entity;


import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@MappedSuperclass

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public abstract class Library_document {
    @Column(name = "label")
    protected String Label=""; // Наименование
    @Column(name = "autor")
    protected String Author=""; // Автор
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Value("0")
    protected int ID; // Идентификатор
    @Column(name = "image")
    protected String Image=""; // Электронный образ

    abstract String Show_document();

    public void setLabel(String label) {
        Label = label;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLabel() {
        return Label;
    }

    public String getAuthor() {
        return Author;
    }

    public int getID() {
        return ID;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
