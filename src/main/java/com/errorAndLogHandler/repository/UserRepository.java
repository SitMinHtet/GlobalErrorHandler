package com.errorAndLogHandler.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.errorAndLogHandler.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    Optional<User> findByEmail(String email);
}