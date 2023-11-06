package com.quan.annotation.stubbing;

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

    public int calculateTotalCost(List<String> bookIds) {
        int total = 0;
        for (String id: bookIds) {
            Book book = bookRepository.findByBookId(id);
            total = total + book.getPrice();
        }
        return total;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }
}
