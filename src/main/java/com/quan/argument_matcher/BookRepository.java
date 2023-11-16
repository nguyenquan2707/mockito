package com.quan.argument_matcher;


import java.time.LocalDate;
import java.util.List;

public interface BookRepository {

    void save(Book book);

    Book findBookById(String bookId);

    Book findBookByTitleAndPublishedDate(String title, LocalDate publishDate);

    Book findBookByTitleAndPriceAndIsDigital(String title, int price, boolean isDigital);

    void saveAll(List<Book> books);
}
