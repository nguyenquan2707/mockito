package com.quan.spied;

public class BookService {

    public Book findBook(String bookId) {
        //Book from database
        //Method is not implemented
        // return null
//        return null;
        throw new RuntimeException("Method not implemented!");
    }

    public int applyDiscount(Book book, int discountRate) {
        Integer price = book.getPrice();
        int newPrice = (price * discountRate / 100);

        return newPrice;
    }
}
