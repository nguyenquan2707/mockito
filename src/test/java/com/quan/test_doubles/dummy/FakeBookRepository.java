package com.quan.test_doubles.dummy;

import com.quan.dummy.Book;
import com.quan.dummy.BookRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FakeBookRepository implements BookRepository {
    //In memory, hashMap, List...
    Map<String, Book> bookStore = new HashMap<>();

    @Override
    public void save(Book book) {
        bookStore.put(book.getBookId(), book);
    }

    @Override
    public Collection<Book> findAll() {

        return bookStore.values();
    }
}
