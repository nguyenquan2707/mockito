package com.quan.test_doubles.mock;

import com.quan.mock.BookService;
import com.quan.mock.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class MockTest {

    @Test
    public void demoMock() {
        BookRepositoryMock repositoryMock = new BookRepositoryMock();
        BookService bookService = new BookService(repositoryMock);

        bookService.addBook(new Book("111", "Mockito in action", 500D, LocalDate.now()));
        Book springInAction = new Book("222", "Spring in action", 150D, LocalDate.now());
        bookService.addBook(springInAction);

        repositoryMock.verify(springInAction, 1);
    }

}
