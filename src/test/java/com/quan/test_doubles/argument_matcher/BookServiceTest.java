package com.quan.test_doubles.argument_matcher;


import com.quan.argument_matcher.Book;
import com.quan.argument_matcher.BookRepository;
import com.quan.argument_matcher.BookRequest;
import com.quan.argument_matcher.BookService;
import org.junit.jupiter.api.Assertions;
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
    public void testUpdatePrice2() {
        Book book = new Book(null, "Mockito",1000, LocalDate.now());
        Book book2 = new Book(null, "Mockito",900, LocalDate.now());
//        Mockito.when(bookRepository.findBookById(Mockito.any())).thenReturn(book);
        Mockito.when(bookRepository.findBookById(Mockito.any(String.class))).thenReturn(book);
        bookService.updatePrice("xyz", 900);
        Mockito.verify(bookRepository).save(book2);
    }

    @Test
    public void testInvalidUseOfArgumentMatchers() {
        Book book = new Book(null, "Mockito",1000, LocalDate.now());
        Mockito.when(bookRepository
//                .findBookByTitleAndPublishedDate("Mockito", Mockito.any(LocalDate.class))).thenReturn(book);
//                .findBookByTitleAndPublishedDate(Mockito.anyString(), Mockito.any(LocalDate.class))).thenReturn(book);
                .findBookByTitleAndPublishedDate(Mockito.eq("Mockito"), Mockito.any(LocalDate.class))).thenReturn(book);

        Book actualBook = bookService.getBookByTitleAndPublishedDate("Mockito", LocalDate.now());

        Assertions.assertEquals("Mockito", actualBook.getTitle());
        Assertions.assertEquals(LocalDate.now(), actualBook.getPublishedDate());
        System.out.println(LocalDate.now());
    }

    @Test
    public void testSpecificTypeOfArgumentMatchers() {
        Book book = new Book(null, "Mockito",1000, LocalDate.now());
        Mockito.when(bookRepository
                .findBookByTitleAndPriceAndIsDigital(Mockito.anyString(), Mockito.anyInt(), Mockito.anyBoolean())).thenReturn(book);

        Book actualBook = bookService.getBookByTitleAndPriceAndIsDigital("Mockito",600, true);

        Assertions.assertEquals("Mockito", actualBook.getTitle());
        Assertions.assertEquals(LocalDate.now(), actualBook.getPublishedDate());
    }
}
