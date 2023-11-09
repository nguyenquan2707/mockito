package com.quan.test_doubles.spies;

import com.quan.spied.Book;
import com.quan.spied.BookManager;
import com.quan.spied.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class BookManagerTest2 {

    @InjectMocks
    private BookManager bookManager;

    @Spy
    private BookService bookService;

    @Test
    public void testMockitoSpy() {

        //TODO, mock getBook
        //TODO, call getDiscountPrice

        Book book = new Book("1234", "Mockito",250, LocalDate.now());
        Mockito.doReturn(book).when(bookService).findBook("1234");

        int discountOnBook = bookManager.discountOnBook("1234", 10);
        Assertions.assertEquals(25, discountOnBook);
    }

    @Test
    public void testMockitoSpy2() {

        Book book = new Book("1234", "Mockito",250, LocalDate.now());
        //No mock, but call real method
        Mockito.when(bookService.findBook("1234")).thenReturn(book);
        int discountOnBook = bookManager.discountOnBook("1234", 10);
        Assertions.assertEquals(25, discountOnBook);
    }
}