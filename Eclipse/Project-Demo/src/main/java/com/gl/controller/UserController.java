package com.gl.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.gl.model.User;
import com.gl.model.User.Role;
import com.gl.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
            Optional<User> user = userService.getUserById(id);
            if (user.isPresent()) {
                return ResponseEntity.ok(user.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/username/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username) {
        try {
            Optional<User> user = userService.getUserByUsername(username);
            if (user.isPresent()) {
                return ResponseEntity.ok(user.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/email/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email) {
        try {
            Optional<User> user = userService.getUserByEmail(email);
            if (user.isPresent()) {
                return ResponseEntity.ok(user.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, 
                                       @RequestBody User userDetails,
                                       @AuthenticationPrincipal User currentUser) {
        try {
            User updatedUser = userService.updateUser(id, userDetails, currentUser);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id,
                                       @AuthenticationPrincipal User currentUser) {
        try {
            userService.deleteUser(id, currentUser);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/role/{role}")
    public List<User> getUsersByRole(@PathVariable Role role) {
        return userService.getUsersSorted(role);
    }
    
    @GetMapping("/owners")
    public List<User> getAllOwners() {
        return userService.getAllUsers();
    }
    
    @GetMapping("/regular")
    public List<User> getAllRegularUsers() {
        return userService.getAllRegularUsers();
    }
    
    @GetMapping("/search/username")
    public List<User> searchUsersByUsername(@RequestParam String username) {
        return userService.searchUsersByUsername(username);
    }
    
    @GetMapping("/search/email")
    public List<User> searchUsersByEmail(@RequestParam String email) {
        return userService.searchUsersByEmail(email);
    }
    
    @GetMapping("/stats/role/{role}")
    public Long getUserCountByRole(@PathVariable Role role) {
        return userService.getUserCountByRole(role);
    }
    
    @GetMapping("/new")
    public List<User> getNewUsers() {
        return userService.getNewUsers();
    }
    
    @GetMapping("/most-active")
    public List<User> getMostActiveUsers() {
        return userService.getMostActiveUsers();
    }
    
    @GetMapping("/app/{appId}/downloaders")
    public List<User> getUsersWhoDownloadedApp(@PathVariable Long appId) {
        return userService.getUsersWhoDownloadedApp(appId);
    }
    
    @GetMapping("/app/{appId}/reviewers")
    public List<User> getUsersWhoReviewedApp(@PathVariable Long appId) {
        return userService.getUsersWhoReviewedApp(appId);
    }
    
    @GetMapping("/profile")
    public User getCurrentUserProfile(@AuthenticationPrincipal User user) {
        return user;
    }
    
    @PutMapping("/profile")
    public ResponseEntity<?> updateCurrentUserProfile(@RequestBody User userDetails,
                                                     @AuthenticationPrincipal User currentUser) {
        try {
            User updatedUser = userService.updateUser(currentUser.getId(), userDetails, currentUser);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}