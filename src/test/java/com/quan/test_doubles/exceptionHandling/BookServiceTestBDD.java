package com.quan.test_doubles.exceptionHandling;

import com.quan.exceptionHandling.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.time.LocalDate;

@ExtendWith(value = MockitoExtension.class)
public class BookServiceTestBDD {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void testTotalPriceOfBook2() throws SQLException {

        BDDMockito.given(bookRepository.findAllBooks());
        Mockito.when(bookRepository.findAllBooks()).thenThrow(new SQLException("Database not available"));
        Assertions.assertThrows(DatabaseReadEXception.class, () -> bookService.getTotalPriceOfBook());
    }
}
