package com.quan.bdd.behavior_verification;


public interface BookRepository {

    void save(Book book);

    Book findBookById(String bookId);
}
