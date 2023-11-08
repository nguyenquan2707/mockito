package com.quan.test_doubles.exceptionHandling;

import com.quan.exceptionHandling.Book;
import com.quan.exceptionHandling.BookRepository;
import com.quan.exceptionHandling.BookService;
import com.quan.exceptionHandling.DatabaseReadEXception;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.time.LocalDate;

@ExtendWith(value = MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void testTotalPriceOfBool() throws SQLException {
        int totalPriceOfBook = bookService.getTotalPriceOfBook();

        Mockito.when(bookRepository.findAllBooks()).thenThrow(SQLException.class);
        Assertions.assertThrows(DatabaseReadEXception.class, () -> bookService.getTotalPriceOfBook());
    }
}
