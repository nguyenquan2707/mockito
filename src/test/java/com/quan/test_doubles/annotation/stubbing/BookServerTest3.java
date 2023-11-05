package com.quan.test_doubles.annotation.stubbing;

import com.quan.annotation.stubbing.Book;
import com.quan.annotation.stubbing.BookRepository;
import com.quan.annotation.stubbing.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@ExtendWith(value = MockitoExtension.class)
public class BookServerTest3 {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void testCalculateTotalCostOfBooks() {

        List<String> bookIds = Arrays.asList("1111", "1111");

        Book book = new Book("1234", "Mockito",250, LocalDate.now());
        Book book2 = new Book("1235", "Mockito5",250, LocalDate.now());

        Mockito.when(bookRepository.findByBookId("1111")).thenReturn(book, book);

        int totalCost = bookService.calculateTotalCost(bookIds);

        Assertions.assertEquals(500, totalCost);
        Mockito.verify(bookRepository, Mockito.times(2)).findByBookId("1111");
    }
}
