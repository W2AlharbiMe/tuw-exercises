package com.example.exercises.Repository;

import com.example.exercises.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    Book findBookById(Integer id);

    Book findBookByTitle(String title);

    List<Book> findBookByCategory(String category);

    @Query("SELECT b FROM Book b WHERE b.numberOfPages > 300")
    List<Book> findBooksByNumberOfPages();


    List<Book> findBooksByAuthor(String author);


}
