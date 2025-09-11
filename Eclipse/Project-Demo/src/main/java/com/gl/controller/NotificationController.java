package com.gl.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.gl.model.Notification;
import com.gl.model.User;
import com.gl.service.NotificationService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    
    @Autowired
    private NotificationService notificationService;
    
    @GetMapping
    public List<Notification> getUserNotifications(@AuthenticationPrincipal User user) {
        return notificationService.getUserNotifications(user.getId());
    }
    
    @GetMapping("/unread")
    public List<Notification> getUnreadNotifications(@AuthenticationPrincipal User user) {
        return notificationService.getUnreadNotifications(user.getId());
    }
    
    @GetMapping("/unread/count")
    public Long getUnreadNotificationCount(@AuthenticationPrincipal User user) {
        return notificationService.getUnreadNotificationCount(user.getId());
    }
    
    @PatchMapping("/{notificationId}/read")
    public ResponseEntity<?> markAsRead(@PathVariable Long notificationId,
                                       @AuthenticationPrincipal User user) {
        try {
            notificationService.markAsRead(notificationId, user.getId());
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PatchMapping("/read-all")
    public ResponseEntity<?> markAllAsRead(@AuthenticationPrincipal User user) {
        try {
            notificationService.markAllAsRead(user.getId());
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @DeleteMapping("/read")
    public ResponseEntity<?> deleteReadNotifications(@AuthenticationPrincipal User user) {
        try {
            notificationService.deleteReadNotifications(user.getId());
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/date-range")
    public ResponseEntity<?> getNotificationsByDateRange(
            @AuthenticationPrincipal User user,
            @RequestParam String startDate, 
            @RequestParam String endDate) {
        try {
            LocalDateTime start = LocalDateTime.parse(startDate);
            LocalDateTime end = LocalDateTime.parse(endDate);
            List<Notification> notifications = notificationService.getNotificationsByDateRange(user.getId(), start, end);
            return ResponseEntity.ok(notifications);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/unread/date-range")
    public ResponseEntity<?> getUnreadNotificationsByDateRange(
            @AuthenticationPrincipal User user,
            @RequestParam String startDate, 
            @RequestParam String endDate) {
        try {
            LocalDateTime start = LocalDateTime.parse(startDate);
            LocalDateTime end = LocalDateTime.parse(endDate);
            List<Notification> notifications = notificationService.getUnreadNotificationsByDateRange(user.getId(), start, end);
            return ResponseEntity.ok(notifications);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/stats/by-type")
    public List<Object[]> getNotificationCountByType(@AuthenticationPrincipal User user) {
        return notificationService.getNotificationCountByType(user.getId());
    }
    
    @GetMapping("/search")
    public List<Notification> searchNotificationsByTitle(
            @AuthenticationPrincipal User user,
            @RequestParam String title) {
        return notificationService.getUserNotifications(user.getId())
            .stream()
            .filter(notification -> notification.getTitle().toLowerCase().contains(title.toLowerCase()))
            .toList();
    }
}
