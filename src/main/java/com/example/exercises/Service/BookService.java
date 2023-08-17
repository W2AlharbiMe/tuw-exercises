package com.example.exercises.Service;

import com.example.exercises.Api.ApiException;
import com.example.exercises.Model.Book;
import com.example.exercises.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookById(Integer id) {
        Book book = bookRepository.findBookById(id);

        if(book == null) {
            throw new ApiException("book not found.");
        }

        return book;
    }

    public Book registerBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Integer id, Book book) {
        Book old_book = bookRepository.findBookById(id);

        if(old_book == null) {
            throw new ApiException("book not found.");
        }

        old_book.setTitle(book.getTitle());
        old_book.setCategory(book.getCategory());
        old_book.setISBN(book.getISBN());
        old_book.setAuthor(book.getAuthor());
        old_book.setNumberOfPages(book.getNumberOfPages());

        bookRepository.save(old_book);

        return old_book;
    }

    public Book deleteBook(Integer id) {
        Book book = bookRepository.findBookById(id);

        if(book == null) {
            throw new ApiException("book not found.");
        }

        bookRepository.deleteById(id);

        return book;
    }

    public Book findBookByTitle(String title) {
        Book book = bookRepository.findBookByTitle(title);

        if(book == null) {
            throw new ApiException("book not found.");
        }

        return book;
    }


    public List<Book> findBooksByCategory(String category) {
        List<Book> books = bookRepository.findBookByCategory(category);

        if(books.isEmpty()) {
            throw new ApiException("no books found with that category.");
        }

        return books;
    }

    public List<Book> findBooksByAuthor(String author) {
        List<Book> books = bookRepository.findBooksByAuthor(author);

        if(books.isEmpty()) {
            throw new ApiException("no books found with that category.");
        }

        return books;
    }


    public List<Book> findBooksMoreThan300() {
        List<Book> books = bookRepository.findBooksByNumberOfPages();

        if(books.isEmpty()) {
            throw new ApiException("no books with more than 300 pages.");
        }

        return books;
    }

}
