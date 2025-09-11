package com.gl.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.model.Notification;
import com.gl.model.User;
import com.gl.repo.NotificationRepository;
import com.gl.repo.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {
    
    @Autowired
    private NotificationRepository notificationRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    public Notification createNotification(Long userId, String title, String message) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        
        Notification notification = new Notification(user, title, message);
        return notificationRepository.save(notification);
    }
    
    public void notifyAllUsers(String title, String message) {
        List<User> allUsers = userRepository.findAll();
        for (User user : allUsers) {
            createNotification(user.getId(), title, message);
        }
    }
    
    public void notifyUser(Long userId, String title, String message) {
        createNotification(userId, title, message);
    }
    
    public void notifyAppOwners(String title, String message) {
        List<User> owners = userRepository.findAll();
        for (User owner : owners) {
            createNotification(owner.getId(), title, message);
        }
    }
    
    public List<Notification> getUserNotifications(Long userId) {
        return notificationRepository.findByUserIdOrderByCreatedAtDesc(userId);
    }
    
    public List<Notification> getUnreadNotifications(Long userId) {
        return notificationRepository.findByUserIdAndIsReadFalse(userId);
    }
    
    public Long getUnreadNotificationCount(Long userId) {
        return notificationRepository.countByUserIdAndIsReadFalse(userId);
    }
    
    public void markAsRead(Long notificationId, Long userId) {
        Notification notification = notificationRepository.findById(notificationId)
            .orElseThrow(() -> new RuntimeException("Notification not found"));
        
        if (!notification.getUser().getId().equals(userId)) {
            throw new RuntimeException("You can only mark your own notifications as read");
        }
        
        notificationRepository.markAsRead(notificationId);
    }
    
    public void markAllAsRead(Long userId) {
        notificationRepository.markAllAsRead(userId);
    }
    
    public void deleteReadNotifications(Long userId) {
        notificationRepository.deleteAllRead(userId);
    }
    
    public List<Notification> getNotificationsByDateRange(Long userId, LocalDateTime startDate, LocalDateTime endDate) {
        return notificationRepository.findByUserIdAndDateRange(userId, startDate, endDate);
    }
    
    public List<Notification> getUnreadNotificationsByDateRange(Long userId, LocalDateTime startDate, LocalDateTime endDate) {
        return notificationRepository.findUnreadByUserIdAndDateRange(userId, startDate, endDate);
    }
    
    public List<Object[]> getNotificationCountByType(Long userId) {
        return notificationRepository.countByTypeForUser(userId);
    }

    public void notifyUser1(Long id, String title, String message) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            User user = userOpt.get();

            Notification notification = new Notification();
            notification.setUser(user);
            notification.setTitle(title);
            notification.setMessage(message);
            notification.setCreatedAt(LocalDateTime.now());

            notificationRepository.save(notification);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

}
