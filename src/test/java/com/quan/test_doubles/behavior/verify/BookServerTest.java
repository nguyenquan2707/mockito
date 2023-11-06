package com.quan.test_doubles.behavior.verify;


import com.quan.behavior.verify.Book;
import com.quan.behavior.verify.BookRepository;
import com.quan.behavior.verify.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(value = MockitoExtension.class)
public class BookServerTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void testAddBook() {
        Book book = new Book(null, "Mockito",500, LocalDate.now());

        bookService.addBook(book);

        Mockito.verify(bookRepository).save(book);
//        Mockito.verify(bookRepository, Mockito.times(1)).save(book);
    }

    @Test
    public void testAddBook2() {
        Book book = new Book(null, "Mockito",250, LocalDate.now());

        bookService.addBook(book);

        Mockito.verify(bookRepository, Mockito.times(0)).save(book);
    }
}
