package com.quan.spy;

import com.quan.dummy.EmailService;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        if(book != null && book.getPrice() > 400) {
            return;
        }
        bookRepository.save(book);
    }

}
