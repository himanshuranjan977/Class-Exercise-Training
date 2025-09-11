package com.gl.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gl.model.Download;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface DownloadRepository extends JpaRepository<Download, Long> {
    List<Download> findByUserId(Long userId);
    List<Download> findByAppId(Long appId);
    Optional<Download> findByUserIdAndAppId(Long userId, Long appId);
    Long countByAppId(Long appId);
    Long countByUserId(Long userId);
    
    // Count downloads by date range
    @Query("SELECT COUNT(d) FROM Download d WHERE d.downloadedAt BETWEEN :startDate AND :endDate")
    Long countByDateRange(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
    
    // Count downloads by app and date range
    @Query("SELECT COUNT(d) FROM Download d WHERE d.app.id = :appId AND d.downloadedAt BETWEEN :startDate AND :endDate")
    Long countByAppIdAndDateRange(@Param("appId") Long appId, 
                                 @Param("startDate") LocalDateTime startDate, 
                                 @Param("endDate") LocalDateTime endDate);
    
    // Get download statistics by app
    @Query("SELECT d.app.id, COUNT(d) FROM Download d GROUP BY d.app.id ORDER BY COUNT(d) DESC")
    List<Object[]> findDownloadCountByApp();
    
    // Get download statistics by user
    @Query("SELECT d.user.id, COUNT(d) FROM Download d GROUP BY d.user.id ORDER BY COUNT(d) DESC")
    List<Object[]> findDownloadCountByUser();
    
    // Get downloads for a specific owner
    @Query("SELECT COUNT(d) FROM Download d WHERE d.app.owner.id = :ownerId")
    Long countByOwnerId(@Param("ownerId") Long ownerId);
    
    // Get download details for a specific owner
    @Query("SELECT d FROM Download d WHERE d.app.owner.id = :ownerId")
    List<Download> findByOwnerId(@Param("ownerId") Long ownerId);
    
    // Get recent downloads for a user
    @Query("SELECT d FROM Download d WHERE d.user.id = :userId ORDER BY d.downloadedAt DESC")
    List<Download> findRecentDownloadsByUserId(@Param("userId") Long userId);
    
    // Check if a user has downloaded any apps from a specific owner
    @Query("SELECT COUNT(d) > 0 FROM Download d WHERE d.user.id = :userId AND d.app.owner.id = :ownerId")
    Boolean existsByUserIdAndOwnerId(@Param("userId") Long userId, @Param("ownerId") Long ownerId);
}
