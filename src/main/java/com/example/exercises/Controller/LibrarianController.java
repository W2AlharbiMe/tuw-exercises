package com.example.exercises.Controller;

import com.example.exercises.Model.Librarian;
import com.example.exercises.Service.LibrarianService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/librarians")
@RequiredArgsConstructor
public class LibrarianController {
    private final LibrarianService librarianService;

    @GetMapping("/get")
    public ResponseEntity<List<Librarian>> findAll() {
        return ResponseEntity.ok(librarianService.findAll());
    }

    @GetMapping("/search/id/{id}")
    public ResponseEntity<Librarian> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(librarianService.findById(id));
    }


    @GetMapping("/search/email/{email}")
    public ResponseEntity<Librarian> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(librarianService.findByEmail(email));
    }


    @GetMapping("/login/{username}/{password}")
    public ResponseEntity<Librarian> findByEmail(@PathVariable String username, @PathVariable String password) {
        return ResponseEntity.ok(librarianService.login(username, password));
    }

    @PostMapping("/create")
    public ResponseEntity<Librarian> create(@RequestBody @Valid Librarian librarian) {
        return ResponseEntity.ok(librarianService.create(librarian));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Librarian> update(@PathVariable Integer id, @RequestBody @Valid Librarian librarian) {
        return ResponseEntity.ok(librarianService.updateLibrarian(id, librarian));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Librarian> update(@PathVariable Integer id) {
        return ResponseEntity.ok(librarianService.deleteLibrarian(id));
    }

}
