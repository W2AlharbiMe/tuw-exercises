package com.example.exercises.Service;

import com.example.exercises.Api.ApiException;
import com.example.exercises.Model.Librarian;
import com.example.exercises.Repository.LibrarianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibrarianService {
    private final LibrarianRepository librarianRepository;

    public List<Librarian> findAll() {
        return librarianRepository.findAll();
    }


    public Librarian findById(Integer id) {
        Librarian librarian = librarianRepository.findLibrarianById(id);

        if(librarian == null) {
            throw new ApiException("librarian not found.");
        }

        return librarian;
    }

    public Librarian findByEmail(String email) {
        Librarian librarian = librarianRepository.findOneByEmail(email);

        if(librarian == null) {
            throw new ApiException("librarian not found.");
        }

        return librarian;
    }

    public Librarian create(Librarian librarian) {
        return librarianRepository.save(librarian);
    }


    public Librarian updateLibrarian(Integer id, Librarian librarian) {
        Librarian old_librarian = librarianRepository.findLibrarianById(id);

        if(old_librarian == null) {
            throw new ApiException("librarian not found.");
        }

        old_librarian.setEmail(librarian.getEmail());
        old_librarian.setPassword(librarian.getPassword());
        old_librarian.setName(librarian.getName());
        old_librarian.setUsername(librarian.getUsername());

        librarianRepository.save(old_librarian);


        return old_librarian;
    }

    public Librarian deleteLibrarian(Integer id) {
        Librarian librarian = librarianRepository.findLibrarianById(id);

        if(librarian == null) {
            throw new ApiException("librarian not found.");
        }

        librarianRepository.deleteById(id);

        return librarian;
    }


    public Librarian login(String username, String password) {
        Librarian librarian = librarianRepository.login(username, password);

        if(librarian == null) {
            throw new ApiException("invalid username or password.");
        }

        return librarian;
    }
}
