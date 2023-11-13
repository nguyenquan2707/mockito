package com.quan.argument_matcher;


import java.time.LocalDate;

public interface BookRepository {

    void save(Book book);

    Book findBookById(String bookId);

    Book findBookByTitleAndPublishedDate(String title, LocalDate publishDate);
}
