package com.quan.test_doubles.argument_matcher;


import com.quan.argument_matcher.Book;
import com.quan.argument_matcher.BookRepository;
import com.quan.argument_matcher.BookRequest;
import com.quan.argument_matcher.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(value = MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public  void testUpdatePrice2() {
        Book book = new Book(null, "Mockito",1000, LocalDate.now());
        Book book2 = new Book(null, "Mockito",900, LocalDate.now());
        Mockito.when(bookRepository.findBookById(Mockito.any())).thenReturn(book);
        bookService.updatePrice("xyz", 900);
        Mockito.verify(bookRepository).save(book2);
    }
}
