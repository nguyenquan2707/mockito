package com.quan.test_doubles.stub;

import com.quan.stub.Book;
import com.quan.stub.BookRepository;
import com.quan.stub.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StubTest {


    @Test
    public void demoStub() {
        BookRepository bookRepository = new BookRepositoryStub();
        BookService bookService = new BookService(bookRepository);

        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);
        Assertions.assertEquals(2, newBooksWithAppliedDiscount.size());
        Assertions.assertEquals(225, newBooksWithAppliedDiscount.get(0).getPrice());
    }
    @Test
    public void demoStubWithMockito() {

        BookRepository bookRepository = Mockito.mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

        Book book = new Book("1234", "Mockito",250, LocalDate.now());
        Book book2 = new Book("1235", "Mockito5",250, LocalDate.now());

        List<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book2);

        Mockito.when(bookRepository.findNewBooks(7)).thenReturn(books);

        Assertions.assertEquals(2, bookService.getNewBooksWithAppliedDiscount(10, 7));

    }

}
