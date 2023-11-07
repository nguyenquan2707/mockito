package com.quan.behavior.verify;


public interface BookRepository {

    void save(Book book);

    Book findBookById(String bookId);
}
