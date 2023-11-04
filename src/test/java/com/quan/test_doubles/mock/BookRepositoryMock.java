package com.quan.test_doubles.mock;

import com.quan.mock.Book;
import com.quan.mock.BookRepository;
import org.junit.jupiter.api.Assertions;

public class BookRepositoryMock implements BookRepository {
    int saveCalled = 0;

    Book lastBook;
    @Override
    public void save(Book book) {
        saveCalled = saveCalled + 1;
        lastBook = book;
    }

    public void verify(Book book, int times) {
        Assertions.assertEquals(times, saveCalled);
        Assertions.assertEquals(book, lastBook);
    }
}
