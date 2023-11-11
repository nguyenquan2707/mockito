package com.quan.test_doubles.bdd.behavioue_verification;


import com.quan.bdd.behavior_verification.Book;
import com.quan.bdd.behavior_verification.BookRepository;
import com.quan.bdd.behavior_verification.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(value = MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public  void testUpdatePrice3() {
        Book book = new Book(null, "Mockito",1000, LocalDate.now());
        Mockito.when(bookRepository.findBookById("1234")).thenReturn(book);
        bookService.updatePrice("1234", 900);


        InOrder inOrder = Mockito.inOrder(bookRepository);
        inOrder.verify(bookRepository).findBookById("1234");
        inOrder.verify(bookRepository).save(book);
    }

    @Test
    public void test_Given_aBook_When_UpdatePriceIsCalledWithNewPrice_Then_BookPriceIsUpdated() {
        //Given - Arrange
        Book book = new Book(null, "Mockito",1000, LocalDate.now());
        BDDMockito.given(bookRepository.findBookById("1234")).willReturn(book);

        //act - when
        bookService.updatePrice("1234", 1000);
        //Assert - verify
        BDDMockito.then(bookRepository).should().findBookById("1234");
    }
}
