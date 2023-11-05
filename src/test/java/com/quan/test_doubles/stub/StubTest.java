package com.quan.test_doubles.stub;

import com.quan.stub.Book;
import com.quan.stub.BookRepository;
import com.quan.stub.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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


    }

}
