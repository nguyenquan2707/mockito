package com.quan.spied;

public class BookManager {

    private BookService bookService;

    public BookManager(BookService bookService) {
        this.bookService = bookService;
    }

    public int discountOnBook(String bookId, int discountRate) {
        Book book = bookService.findBook(bookId); //need to mock

        int disCountPrice = bookService.applyDiscount(book, discountRate); // need to actual call

        return disCountPrice;
    }
}
