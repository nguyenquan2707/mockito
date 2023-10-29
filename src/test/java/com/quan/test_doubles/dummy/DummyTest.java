package com.quan.test_doubles.dummy;

import com.quan.dummy.BookService;
import com.quan.dummy.EmailService;
import com.quan.dummy.Book;
import com.quan.dummy.BookRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DummyTest {

    //Stub object provides predefined answers to method executions made during the test.
    //Behaviors is hardcode programmatically for particular test.
    //Instead of call external service, stub is called, and it returns back an expected response.

    @Test
    public void demoDummy() {

        BookRepository bookRepository = new FakeBookRepository();
        EmailService emailService = new DummyEmailService();
        BookService bookService = new BookService(bookRepository, emailService);

        bookService.addBook(new Book("id1", "Java", 100D, LocalDate.now()));
        bookService.addBook(new Book("id2", "JavaScript", 90D, LocalDate.now()));

        assertEquals(2, bookService.numberOfBook());

    }

}
