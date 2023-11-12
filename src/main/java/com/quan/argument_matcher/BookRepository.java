package com.quan.argument_matcher;


public interface BookRepository {

    void save(Book book);

    Book findBookById(String bookId);
}
