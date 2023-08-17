package com.example.exercises.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @NotEmpty(message = "the title field is required.")
    @Column(columnDefinition = "varchar(120) not null unique")
    private String title;


    @NotEmpty(message = "the author field is required.")
    @Column(columnDefinition = "varchar(120) not null unique")
    private String author;


    @NotEmpty(message = "the category field is required.")
    @Pattern(message = "the category can only be `academic`, `mystery`, `novel`.", regexp = "(?i)\\b(academic|mystery|novel)\\b?")
    @Column(columnDefinition = "varchar(8) not null check (category in ('academic', 'mystery', 'novel'))")
    private String category;


    @NotNull(message = "the ISBN field is required.")
    @Column(columnDefinition = "int(13) not null")
    private Integer ISBN;


//    @NotNull(message = "the number of pages field is required.") // this does not work!
//    @Min(value = 50, message = "the numberOfPages must be at least 50.") // this does not work!
    @Column(columnDefinition = "int(255) not null check (number_of_pages >= 50)")
    private Integer numberOfPages;

}
