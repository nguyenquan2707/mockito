package com.quan.test_doubles.bdd.stubbing;

import com.quan.bdd.stubbing.Book;
import com.quan.bdd.stubbing.BookRepository;
import com.quan.bdd.stubbing.BookService;
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

@ExtendWith(MockitoExtension.class)
public class StubTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void demoStubWithMockito() {

        Book book = new Book("1234", "Mockito",250, LocalDate.now());
        Book book2 = new Book("1235", "Mockito5",250, LocalDate.now());

        List<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book2);

        Mockito.when(bookRepository.findNewBooks(7)).thenReturn(books);

        Assertions.assertEquals(2, bookService.getNewBooksWithAppliedDiscount(10, 7).size());

    }

}
