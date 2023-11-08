package com.quan.test_doubles.behavior.verify;


import com.quan.behavior.verify.Book;
import com.quan.behavior.verify.BookRepository;
import com.quan.behavior.verify.BookRequest;
import com.quan.behavior.verify.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
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

    @Test
    public void testSaveBookWithBookRequest() {

        BookRequest bookRequest = new BookRequest("Mockito", 600, LocalDate.now());

        Book book = new Book(null, "Mockito",600, LocalDate.now());

        bookService.addBook(bookRequest);
        Mockito.verify(bookRepository, Mockito.times(1)).save(book);
    }

    @Test
    public void testSaveBookWithBookRequest2() {

        BookRequest bookRequest = new BookRequest("Mockito", 300, LocalDate.now());

        Book book = new Book(null, "Mockito",300, LocalDate.now());

        bookService.addBook(bookRequest);
        Mockito.verify(bookRepository, Mockito.times(0)).save(book);
    }

    @Test
    public void testSaveBookWithBookRequestWithGreaterPrice() {

        BookRequest bookRequest = new BookRequest("Mockito", 300, LocalDate.now());

        Book book = new Book(null, "Mockito",300, LocalDate.now());

        bookService.addBook(bookRequest);
        Mockito.verify(bookRepository, Mockito.never()).save(book);
    }

    @Test
    public  void testUpdatePrice() {
        bookService.updatePrice(null, 1000);

        Mockito.verifyNoInteractions(bookRepository);
    }

    @Test
    public  void testUpdatePrice2() {
        Book book = new Book(null, "Mockito",1000, LocalDate.now());
        Mockito.when(bookRepository.findBookById("1234")).thenReturn(book);
        bookService.updatePrice("1234", 1000);

        Mockito.verify(bookRepository).findBookById("1234");
        //after this, no method of bookRepository is callled
        Mockito.verifyNoMoreInteractions(bookRepository);
    }

    @Test
    public  void testUpdatePrice3() {
        Book book = new Book(null, "Mockito",1000, LocalDate.now());
        Mockito.when(bookRepository.findBookById("1234")).thenReturn(book);
        bookService.updatePrice("1234", 900);


        InOrder inOrder = Mockito.inOrder(bookRepository);
        inOrder.verify(bookRepository).findBookById("1234");
        inOrder.verify(bookRepository).save(book);
    }

    @Test
    public void testSaveBookWithBookRequestWithGreaterPrice2() {

        BookRequest bookRequest = new BookRequest("Mockito", 600, LocalDate.now());

        Book book = new Book(null, "Mockito",600, LocalDate.now());

        bookService.addBook(bookRequest);
        bookService.addBook(bookRequest);
        bookService.addBook(bookRequest);
        Mockito.verify(bookRepository, Mockito.atLeast(2)).save(book);
    }

    @Test
    public void testSaveBookWithBookRequestWithGreaterPrice3() {

        BookRequest bookRequest = new BookRequest("Mockito", 600, LocalDate.now());

        Book book = new Book(null, "Mockito",600, LocalDate.now());

        bookService.addBook(bookRequest);
        bookService.addBook(bookRequest);
        bookService.addBook(bookRequest);
        Mockito.verify(bookRepository, Mockito.atMost(4)).save(book);
    }

    @Test
    public void testSaveBookWithBookRequestWithGreaterPrice4() {

        BookRequest bookRequest = new BookRequest("Mockito", 600, LocalDate.now());

        Book book = new Book(null, "Mockito",600, LocalDate.now());

        bookService.addBook(bookRequest);
//        bookService.addBook(bookRequest);
        Mockito.verify(bookRepository, Mockito.atMostOnce()).save(book);
    }

    @Test
    public void testSaveBookWithBookRequestWithGreaterPrice5() {

        BookRequest bookRequest = new BookRequest("Mockito", 600, LocalDate.now());

        Book book = new Book(null, "Mockito",600, LocalDate.now());

        bookService.addBook(bookRequest);
        bookService.addBook(bookRequest);
        Mockito.verify(bookRepository, Mockito.atLeastOnce()).save(book);
    }
}
