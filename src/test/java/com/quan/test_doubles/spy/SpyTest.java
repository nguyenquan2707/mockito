package com.quan.test_doubles.spy;

import com.quan.spy.Book;
import com.quan.spy.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class SpyTest {

    @Test
    public void demoSpy() {
        BookRepositorySpy bookRepositorySpy = new BookRepositorySpy();
        BookService bookService = new BookService(bookRepositorySpy);

        bookService.addBook(new Book("111", "Mockito in action", 100D, LocalDate.now()));
        Book springInAction = new Book("222", "Spring in action", 150D, LocalDate.now());
        bookService.addBook(springInAction);

        Assertions.assertEquals(2, bookRepositorySpy.timesCalled());
        Assertions.assertTrue(bookRepositorySpy.calledWith(springInAction));

    }

    @Test
    public void  demoSpy_whenPriceMoreThan400() {
        BookRepositorySpy bookRepositorySpy = new BookRepositorySpy();
        BookService bookService = new BookService(bookRepositorySpy);

        Book mockitoInAction = new Book("111", "Mockito in action", 100D, LocalDate.now());
        bookService.addBook(mockitoInAction);
        Book springInAction = new Book("222", "Spring in action", 550D, LocalDate.now());
        bookService.addBook(springInAction);

        Assertions.assertEquals(1, bookRepositorySpy.timesCalled());
        Assertions.assertTrue(bookRepositorySpy.calledWith(mockitoInAction));
        Assertions.assertFalse(bookRepositorySpy.calledWith(springInAction));
    }
}
