package com.example.exercises.Repository;

import com.example.exercises.Model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Integer> {

    Librarian findLibrarianById(Integer id);

    @Query("SELECT l FROM Librarian l WHERE  l.email = ?1")
    Librarian findOneByEmail(String email);

    @Query("SELECT l FROM Librarian l WHERE  l.username = ?1 AND l.password = ?2")
    Librarian login(String username, String password);
}
