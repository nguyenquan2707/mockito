package com.quan.test_doubles.fake;

import com.quan.fake.BookService;
import com.quan.fake.repo.Book;
import com.quan.fake.repo.BookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class FakeTest {

    @Test
    public void testFake() {
        BookService bookService = new BookService(new FakeBookRepository());

        bookService.addBook(new Book("id1", "Java", 100D, LocalDate.now()));
        bookService.addBook(new Book("id2", "JavaScript", 90D, LocalDate.now()));

        assertEquals(2, bookService.numberOfBook());
    }

    @Test
    public void testFakeWithMockito() {
        BookRepository bookRepository = mock(BookRepository.class);

        BookService bookService = new BookService(bookRepository);

        Book book = new Book("id1", "Java", 100D, LocalDate.now());
        Book book2 = new Book("id2", "JavaScript", 90D, LocalDate.now());

        Collection<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book2);

        bookRepository.findAll();
        Mockito.when(bookRepository.findAll()).thenReturn(books);

        assertEquals(2, bookService.numberOfBook());
    }
}
