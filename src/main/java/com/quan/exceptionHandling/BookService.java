package com.quan.exceptionHandling;

import java.sql.SQLException;
import java.util.List;

public class BookService {

    private BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public int getTotalPriceOfBook() {
        List<Book> books = null;
        try {
            books = bookRepository.findAllBooks();
        } catch (SQLException e) {
            throw new DatabaseReadEXception("Unable to read from database " + e.getMessage());
        }
        int totalPrice = 0;
        for (Book book: books) {
            totalPrice = totalPrice + book.getPrice();
        }
        return totalPrice;
    }

}
