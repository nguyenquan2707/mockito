package com.quan.test_doubles.fake;

import com.quan.fake.repo.Book;
import com.quan.fake.repo.BookRepository;

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
