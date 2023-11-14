package com.quan.argument_matcher;

import java.time.LocalDate;

public class BookService {

    private BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        if(book.getPrice() < 400) {
            return;
        }
        bookRepository.save(book);
    }

    public void addBook(BookRequest book) {
        if(book.getPrice() < 400) {
            return;
        }
        Book book1 = new Book();
        book1.setTitle(book.getTitle());
        book1.setPrice(book.getPrice());
        book1.setPublishedDate(book.getPublishedDate());

        bookRepository.save(book1);
    }

    public void updatePrice(String bookId, int updatePrice) {
        if(bookId == null) {
            return;
        }
        Book book = bookRepository.findBookById(bookId);
        if(book.getPrice() == updatePrice) {
            return;
        }
        book.setPrice(updatePrice);

        bookRepository.save(book);
    }


    public Book getBookByTitleAndPublishedDate(String title, LocalDate publishDate) {
        return bookRepository.findBookByTitleAndPublishedDate(title, publishDate);
    }

    public Book getBookByTitleAndPriceAndIsDigital(String title, int price, boolean isDigital) {
        return bookRepository.findBookByTitleAndPriceAndIsDigital(title, price, isDigital);
    }
}
