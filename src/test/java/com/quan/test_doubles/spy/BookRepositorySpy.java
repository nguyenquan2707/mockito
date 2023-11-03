package com.quan.test_doubles.spy;

import com.quan.spy.Book;
import com.quan.spy.BookRepository;

public class BookRepositorySpy implements BookRepository {
    int saveCalled = 0;

    Book lastBook = null;
    @Override
    public void save(Book book) {
        saveCalled = saveCalled + 1;
        lastBook = book;
    }

    public int timesCalled() {
        return saveCalled;
    }

    public boolean calledWith(Book book) {
        return lastBook.equals(book);
    }
}
