package com.quan.stub;

import com.quan.dummy.Book;

import java.util.Collection;

public interface BookRepository {

    void save(com.quan.dummy.Book book);
    Collection<Book> findAll();
}
