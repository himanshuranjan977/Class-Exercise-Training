package com.gl.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    // find role by its name
    Optional<Role> findByName(String name);
}