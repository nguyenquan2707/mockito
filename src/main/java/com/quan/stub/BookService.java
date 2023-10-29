package com.quan.stub;

import com.quan.fake.repo.Book;
import com.quan.fake.repo.BookRepository;

public class BookService {

    private BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public int numberOfBook() {
        return bookRepository.findAll().size();
    }
}
