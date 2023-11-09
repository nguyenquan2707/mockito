package com.quan.test_doubles.spies;

import com.quan.spied.BookManager;
import com.quan.spied.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BookManagerTest {

    @Test
    public void testMockitoSpy() {
        BookService bookService = Mockito.spy(BookService.class);
        BookManager bookManager = new BookManager(bookService);

    }
}