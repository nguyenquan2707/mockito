package com.quan.stub;

import com.quan.stub.Book;
import com.quan.stub.BookRepository;

import java.util.List;

public class BookService {

    private BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getNewBooksWithAppliedDiscount(int discount, int days) {
        List<Book> newBooks = bookRepository.findNewBooks(days);
        for (Book book: newBooks) {
            int price = book.getPrice();
            int newPrice = price - (discount * price/100);
            book.setPrice(newPrice);
        }
        return newBooks;
    }
}
