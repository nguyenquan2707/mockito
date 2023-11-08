package com.quan.exceptionHandling;

import java.time.LocalDate;

public class BookRequest {

    private String title;
    private Integer price;

    private LocalDate publishedDate;

    public BookRequest(String title, Integer price, LocalDate publishedDate) {
        this.title = title;
        this.price = price;
        this.publishedDate = publishedDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

}
