package com.quan.test_doubles.mock;

import com.quan.mock.BookRepository;
import com.quan.mock.BookService;
import com.quan.mock.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

public class MockTest {

    @Test
    public void demoMock() {
        BookRepositoryMock repositoryMock = new BookRepositoryMock();
        BookService bookService = new BookService(repositoryMock);

        bookService.addBook(new Book("111", "Mockito in action", 500D, LocalDate.now()));
        Book springInAction = new Book("222", "Spring in action", 150D, LocalDate.now());
        bookService.addBook(springInAction);

        repositoryMock.verify(springInAction, 1);
    }

    @Test
    public void demoMockWithMockito() {
        BookRepository bookRepository = Mockito.mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

        Book book = new Book("111", "Mockito in action", 500D, LocalDate.now());
        Book springInAction = new Book("222", "Spring in action", 150D, LocalDate.now());
        bookService.addBook(book);
        bookService.addBook(springInAction);

//        BookRepository bookRepositoryVerify = Mockito.verify(bookRepository);
        BookRepository bookRepositoryVerifyForSpringInAction = Mockito.verify(bookRepository, Mockito.times(1));
        //Check save(sprintInAction) is called.
        bookRepositoryVerifyForSpringInAction.save(springInAction);

        BookRepository repositoryForBook = Mockito.verify(bookRepository, Mockito.times(0));
        repositoryForBook.save(book);

    }

}
