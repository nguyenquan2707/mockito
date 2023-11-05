package com.quan.test_doubles.annotation.suppot;

import com.quan.annotation.support.Book;
import com.quan.annotation.support.BookRepository;
import com.quan.annotation.support.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(value = MockitoExtension.class)
public class AnnotationTest2 {

    //Khi sử dụng @Mock thì dùng @InjectMocks

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void demoCreateMockUsingAnnotation() {

        Book book = new Book("1234", "Mockito",250, LocalDate.now());
        Book book2 = new Book("1235", "Mockito5",250, LocalDate.now());
        List<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book2);

        Mockito.when(bookRepository.findNewBooks(7)).thenReturn(books);

        Assertions.assertEquals(2, bookService.getNewBooksWithAppliedDiscount(10, 7).size());
    }
}
