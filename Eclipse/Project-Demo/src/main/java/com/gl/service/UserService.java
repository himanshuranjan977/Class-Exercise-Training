package com.gl.service;

import com.gl.model.User;
import com.gl.model.User.Role;
import com.gl.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // ✅ Register a new user
    public User registerUser(User request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword()); // storing as plain text
        user.setEmail(request.getEmail());
        user.setRole(request.getRole() != null ? request.getRole() : Role.USER);

        return userRepository.save(user);
    }

    // ✅ Authenticate user (login)
    public User authenticateUser(String username, String rawPassword) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!rawPassword.equals(user.getPassword())) { // plain text comparison
            throw new RuntimeException("Invalid password");
        }

        return user;
    }

    // ✅ Update user profile
    public User updateUser(Long userId, User userDetails, User currentUser) {
        if (!userId.equals(currentUser.getId()) && currentUser.getRole() != Role.OWNER) {
            throw new RuntimeException("You can only update your own profile");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Validate unique username
        if (!user.getUsername().equals(userDetails.getUsername())
                && userRepository.existsByUsername(userDetails.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        // Validate unique email
        if (!user.getEmail().equals(userDetails.getEmail())
                && userRepository.existsByEmail(userDetails.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());

        // Update password if provided
        if (userDetails.getPassword() != null && !userDetails.getPassword().isEmpty()) {
            user.setPassword(userDetails.getPassword()); // plain text
        }

        return userRepository.save(user);
    }

    // ✅ Delete user account
    public void deleteUser(Long userId, User currentUser) {
        if (!userId.equals(currentUser.getId()) && currentUser.getRole() != Role.OWNER) {
            throw new RuntimeException("You can only delete your own account");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getOwnedApps() != null && !user.getOwnedApps().isEmpty()) {
            throw new RuntimeException("Cannot delete user who owns apps");
        }

        userRepository.delete(user);
    }

    // ✅ Get user by id/username/email
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // ✅ Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ✅ Get users sorted by field
    public List<User> getUsersSorted(Role role) {
        return userRepository.getById(role);
    }

    // ✅ Search users
    public List<User> searchUsersByUsername(String username) {
        return userRepository.findByUsernameContainingIgnoreCase(username);
    }

    public List<User> searchUsersByEmail(String email) {
        return userRepository.findByEmailContainingIgnoreCase(email);
    }

    // ✅ Count users by role
    public Long getUserCountByRole(Role role) {
        return userRepository.countByRole(role);
    }

    // ✅ Special queries
    public List<User> getNewUsers() {
        return userRepository.findNewUsers();
    }

    public List<User> getMostActiveUsers() {
        return userRepository.findMostActiveUsers();
    }

    public List<User> getUsersWhoDownloadedApp(Long appId) {
        return userRepository.findUsersWhoDownloadedApp(appId);
    }

	public List<User> getAllRegularUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getUsersWhoReviewedApp(Long appId) {
		// TODO Auto-generated method stub
		return null;
	}
}

