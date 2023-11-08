package com.quan.test_doubles.argument_captor;


import com.quan.arguent_captor.Book;
import com.quan.arguent_captor.BookRepository;
import com.quan.arguent_captor.BookRequest;
import com.quan.arguent_captor.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
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
    public void testSaveBookWithBookRequest() {

        BookRequest bookRequest = new BookRequest("Mockito", 600, LocalDate.now());

        ArgumentCaptor<Book> bookArgumentCaptor = ArgumentCaptor.forClass(Book.class);

        bookService.addBook(bookRequest);
        Mockito.verify(bookRepository).save(bookArgumentCaptor.capture());

        Book book = bookArgumentCaptor.getValue();
        Assertions.assertEquals("Mockito", book.getTitle());
        Assertions.assertEquals(600, book.getPrice());
    }

}
