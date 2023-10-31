package com.quan.test_doubles.stub;

import com.quan.stub.Book;
import com.quan.stub.BookRepository;
import com.quan.stub.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StubTest {


    @Test
    public void demoStub() {
        BookRepository bookRepository = new BookRepositoryStub();
        BookService bookService = new BookService(bookRepository);

        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(5, 7);
        Assertions.assertEquals(2, newBooksWithAppliedDiscount.size());
    }

}
