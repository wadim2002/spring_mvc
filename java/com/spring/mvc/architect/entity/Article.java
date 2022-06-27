package com.spring.mvc.architect.entity;

public class Article extends Library_document {
    private String Compilation;

    public Article(String label, String author, int ID, String compilation) {
        super.setLabel(label);
        super.setAuthor(author);
        super.setID(ID);
        this.Compilation = compilation;
    }

    public String getCompilation() {
        return Compilation;
    }

    @Override
    public String Show_document() {
        return "";
    }
}
