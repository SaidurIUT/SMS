package com.project.SMS.repository;

import com.project.SMS.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    Optional<User> findByName(String name);
    Optional<User> findById(Long id);
}
