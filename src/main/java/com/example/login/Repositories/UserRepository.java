package com.example.login.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import com.example.login.Models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
