package com.gl.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    // find user by username
    Optional<User> findByUsername(String username);

    // check if a user exists by username
    boolean existsByUsername(String username);
}
