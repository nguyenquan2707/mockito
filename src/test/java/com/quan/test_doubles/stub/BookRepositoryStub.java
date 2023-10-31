package com.quan.test_doubles.stub;

import com.quan.stub.Book;
import com.quan.stub.BookRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class BookRepositoryStub implements BookRepository {
    @Override
    public List<Book> findNewBooks(int days) {
        Book book = new Book("1234", "Mockito",250, LocalDate.now());
        Book book2 = new Book("1235", "Mockito5",250, LocalDate.now());
        List<Book> list = Arrays.asList(book, book2);
        return list;
    }
}
