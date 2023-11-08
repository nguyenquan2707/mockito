package com.quan.test_doubles.exceptionHandling;

import com.quan.exceptionHandling.*;
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
        Mockito.when(bookRepository.findAllBooks()).thenThrow(SQLException.class);
        Assertions.assertThrows(DatabaseReadEXception.class, () -> bookService.getTotalPriceOfBook());
    }

    @Test
    public void testAddBooK() throws SQLException {

        Book book = new Book(null, "Mockito",600, LocalDate.now());

        Mockito.doThrow(SQLException.class).when(bookRepository).save(book);

        Assertions.assertThrows(DatabaseWriteException.class, () -> bookService.addBook(book));
    }

    @Test
    public void testTotalPriceOfBook2() throws SQLException {

        Mockito.when(bookRepository.findAllBooks()).thenThrow(new SQLException("Database not available"));
        Assertions.assertThrows(DatabaseReadEXception.class, () -> bookService.getTotalPriceOfBook());
    }
}
