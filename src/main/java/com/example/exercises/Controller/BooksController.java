package com.example.exercises.Controller;

import com.example.exercises.Model.Book;
import com.example.exercises.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BooksController {

    private final BookService bookService;

    @GetMapping("/get")
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.ok(bookService.findAllBooks());
    }


    @GetMapping("/search/id/{id}")
    public ResponseEntity<Book> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(bookService.findBookById(id));
    }

    @GetMapping("/search/title/{title}")
    public ResponseEntity<Book> findByTitle(@PathVariable String title) {
        return ResponseEntity.ok(bookService.findBookByTitle(title));
    }

    @GetMapping("/search/author/{author}")
    public ResponseEntity<List<Book>> findBooksByAuthor(@PathVariable String author) {
        return ResponseEntity.ok(bookService.findBooksByAuthor(author));
    }

    @GetMapping("/search/category/{category}")
    public ResponseEntity<List<Book>> findBooksByCategory(@PathVariable String category) {
        return ResponseEntity.ok(bookService.findBooksByCategory(category));
    }

    @GetMapping("/300")
    public ResponseEntity<List<Book>> findBooksByNumberOfPages() {
        return ResponseEntity.ok(bookService.findBooksMoreThan300());
    }

    @PostMapping("/register")
    public ResponseEntity<Book> registerBook(@RequestBody @Valid Book book) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.registerBook(book));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Integer id, @RequestBody @Valid Book book) {
        return ResponseEntity.ok(bookService.updateBook(id, book));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> registerBook(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.deleteBook(id));
    }

}
