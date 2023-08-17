package com.example.exercises.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "the name field is required.")
    @Size(min = 5, message = "the name must be more than 4 chars.")
    private String name;

    @NotEmpty(message = "the username field is required.")
    @Size(min = 4, message = "the username must be more than 3 chars.")
    private String username;

    @NotEmpty(message = "the password field is required.")
    @Pattern(message = "the password must contain at least seven characters, at least one number and both lower and uppercase letters and special characters", regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")
    private String password;

    @NotEmpty(message = "the email field is required.")
    @Email(message = "invalid email.")
    private String email;

}
