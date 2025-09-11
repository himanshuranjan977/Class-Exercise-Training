package com.gl.security;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

    // select * from user where username = ?
    Optional<User> findByUsername(String username);
}
