package com.example.Tuan2.entity;

import com.example.Tuan2.validator.annotation.ValidUsername;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", length = 50, nullable = false, unique = true)
    @NotBlank(message = "Username is required")
    @Size(max = 60, message = "Username must be less than 60 characters")
    @ValidUsername
    private String username;
    @Column(name = "password", length = 250, nullable = false)
    @NotBlank(message = "Password is required")
    private String password;
    @Column(name = "email", length = 50)
    @Size(max = 60, message = "Email must be less than 60 characters")
    private String email;
    @Column(name = "name", length = 50, nullable = false)
    @Size(max = 60, message = "Your name must be less than 60 characters")
    @NotBlank(message = "Your name is required")
    private String name;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<NhanVien> nhanViens = new ArrayList<>();
}
