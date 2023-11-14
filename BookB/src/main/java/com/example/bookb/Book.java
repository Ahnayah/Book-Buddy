package com.example.bookb;

public class Book {
    private final String title;
    private final String author;
    private final Integer rate;


    public Book(String title, String author, Integer rate) {
        this.title = title;
        this.author = author;
        this.rate = rate;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getRate(){return rate;}
}
