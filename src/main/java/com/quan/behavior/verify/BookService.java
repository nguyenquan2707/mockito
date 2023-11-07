package com.quan.behavior.verify;

public class BookService {

    private BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        if(book.getPrice() < 400) {
            return;
        }
        bookRepository.save(book);
    }

    public void addBook(BookRequest book) {
        if(book.getPrice() < 400) {
            return;
        }
        Book book1 = new Book();
        book1.setTitle(book.getTitle());
        book1.setPrice(book.getPrice());
        book1.setPublishedDate(book.getPublishedDate());

        bookRepository.save(book1);
    }

    public void updatePrice(String bookId, int updatePrice) {
        if(bookId == null) {
            return;
        }
        Book book = bookRepository.findBookById(bookId);
        book.setPrice(updatePrice);

        bookRepository.save(book);
    }
}
