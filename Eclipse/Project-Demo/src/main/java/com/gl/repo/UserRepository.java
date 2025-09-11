package com.gl.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gl.model.User;
import com.gl.model.User.Role;

public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

    // Search support
    List<User> findByUsernameContainingIgnoreCase(String username);
    List<User> findByEmailContainingIgnoreCase(String email);

    // Count users by role
    Long countByRole(Role role);

    // Custom queries (example logic, adjust based on your schema)

    // Find new users by registration date (assuming you have createdAt)
    @Query("SELECT u FROM User u ORDER BY u.createdAt DESC")
    List<User> findNewUsers();

    // Find most active users (assuming you have downloads or reviews tracking)
    @Query("SELECT u FROM User u ORDER BY size(u.downloadedApps) DESC")
    List<User> findMostActiveUsers();

    // Find users who downloaded a specific app (assuming a relation exists)
    @Query("SELECT u FROM User u JOIN u.downloadedApps a WHERE a.id = :appId")
    List<User> findUsersWhoDownloadedApp(Long appId);
	List<User> getById(Role role);
}
