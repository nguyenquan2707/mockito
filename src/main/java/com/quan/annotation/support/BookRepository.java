package com.quan.annotation.support;


import com.quan.annotation.support.Book;

import java.util.List;

public interface BookRepository {

    List<Book> findNewBooks(int days);
}
