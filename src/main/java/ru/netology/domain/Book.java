package ru.netology.domain;

public class Book extends Product {
    private String author;

    public Book() {
        super();
    }

    public Book(int id, String productName, int cost, String author) {
        super(id, productName, cost);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}