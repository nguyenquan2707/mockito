package com.quan.annotation.stubbing;

import java.util.List;

public interface BookRepository {

    List<Book> findNewBooks(int days);

    Book findByBookId(String id);
}
