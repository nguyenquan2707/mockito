package com.quan.test_doubles.fake;

import com.quan.fake.BookService;
import com.quan.fake.repo.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class FakeTest {

    @Test
    public void testFake() {
        BookService bookService = new BookService(new FakeBookRepository());

        bookService.addBook(new Book("id1", "Java", 100D, LocalDate.now()));
        bookService.addBook(new Book("id2", "JavaScript", 90D, LocalDate.now()));


    }
}
