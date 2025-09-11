package com.gl.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gl.model.Notification;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUserId(Long userId);
    List<Notification> findByUserIdAndIsReadFalse(Long userId);
    List<Notification> findByUserIdAndIsReadTrue(Long userId);
    Long countByUserIdAndIsReadFalse(Long userId);
    
    // Find notifications by date range
    @Query("SELECT n FROM Notification n WHERE n.user.id = :userId AND n.createdAt BETWEEN :startDate AND :endDate")
    List<Notification> findByUserIdAndDateRange(@Param("userId") Long userId, 
                                               @Param("startDate") LocalDateTime startDate, 
                                               @Param("endDate") LocalDateTime endDate);
    
    // Find unread notifications by date range
    @Query("SELECT n FROM Notification n WHERE n.user.id = :userId AND n.isRead = false AND n.createdAt BETWEEN :startDate AND :endDate")
    List<Notification> findUnreadByUserIdAndDateRange(@Param("userId") Long userId, 
                                                     @Param("startDate") LocalDateTime startDate, 
                                                     @Param("endDate") LocalDateTime endDate);
    
    // Find notifications sorted by creation date
    @Query("SELECT n FROM Notification n WHERE n.user.id = :userId ORDER BY n.createdAt DESC")
    List<Notification> findByUserIdOrderByCreatedAtDesc(@Param("userId") Long userId);
    
    // Find notifications with specific title pattern
    @Query("SELECT n FROM Notification n WHERE n.user.id = :userId AND n.title LIKE %:title%")
    List<Notification> findByUserIdAndTitleContaining(@Param("userId") Long userId, @Param("title") String title);
    
    // Mark a specific notification as read
    @Modifying
    @Transactional
    @Query("UPDATE Notification n SET n.isRead = true WHERE n.id = :id")
    void markAsRead(@Param("id") Long id);
    
    // Mark all notifications for a user as read
    @Modifying
    @Transactional
    @Query("UPDATE Notification n SET n.isRead = true WHERE n.user.id = :userId")
    void markAllAsRead(@Param("userId") Long userId);
    
    // Delete all read notifications for a user
    @Modifying
    @Transactional
    @Query("DELETE FROM Notification n WHERE n.user.id = :userId AND n.isRead = true")
    void deleteAllRead(@Param("userId") Long userId);
    
    // Delete notifications older than a specific date
    @Modifying
    @Transactional
    @Query("DELETE FROM Notification n WHERE n.createdAt < :date")
    void deleteOlderThan(@Param("date") LocalDateTime date);
    
    // Count notifications by type (based on title pattern)
    @Query("SELECT n.title, COUNT(n) FROM Notification n WHERE n.user.id = :userId GROUP BY n.title")
    List<Object[]> countByTypeForUser(@Param("userId") Long userId);
}