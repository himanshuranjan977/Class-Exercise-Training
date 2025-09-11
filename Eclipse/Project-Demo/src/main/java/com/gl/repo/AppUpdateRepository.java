package com.gl.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gl.model.AppUpdate;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppUpdateRepository extends JpaRepository<AppUpdate, Long> {
    List<AppUpdate> findByAppId(Long appId);
    List<AppUpdate> findByAppIdOrderByReleaseDateDesc(Long appId);
    List<AppUpdate> findByReleaseDateAfter(LocalDate date);
    List<AppUpdate> findByReleaseDateBefore(LocalDate date);
    List<AppUpdate> findByReleaseDateBetween(LocalDate startDate, LocalDate endDate);
    
    // Find updates for apps owned by a specific owner
    @Query("SELECT au FROM AppUpdate au WHERE au.app.owner.id = :ownerId")
    List<AppUpdate> findByOwnerId(@Param("ownerId") Long ownerId);
    
    // Find updates for a specific app owned by a specific owner
    @Query("SELECT au FROM AppUpdate au WHERE au.app.owner.id = :ownerId AND au.app.id = :appId")
    List<AppUpdate> findByOwnerIdAndAppId(@Param("ownerId") Long ownerId, @Param("appId") Long appId);
    
    // Find updates by app ID and version
    @Query("SELECT au FROM AppUpdate au WHERE au.app.id = :appId AND au.version = :version")
    Optional<AppUpdate> findByAppIdAndVersion(@Param("appId") Long appId, @Param("version") String version);
    
    // Find the latest update for each app owned by a specific owner
    @Query("SELECT au FROM AppUpdate au WHERE au.id IN (" +
           "SELECT MAX(au2.id) FROM AppUpdate au2 WHERE au2.app.owner.id = :ownerId GROUP BY au2.app.id)")
    List<AppUpdate> findLatestUpdatesByOwnerId(@Param("ownerId") Long ownerId);
    
    // Find updates released in the last N days
    @Query("SELECT au FROM AppUpdate au WHERE au.releaseDate >= CURRENT_DATE - :days")
    List<AppUpdate> findRecentUpdates(@Param("days") Long days);
    
    // Count updates by app
    @Query("SELECT au.app.id, COUNT(au) FROM AppUpdate au GROUP BY au.app.id ORDER BY COUNT(au) DESC")
    List<Object[]> countUpdatesByApp();
    
    // Find updates with version greater than a specific version
    @Query("SELECT au FROM AppUpdate au WHERE au.app.id = :appId AND au.version > :version ORDER BY au.version DESC")
    List<AppUpdate> findUpdatesNewerThanVersion(@Param("appId") Long appId, @Param("version") String version);
    
    // Check if an update exists for a specific app and version
    @Query("SELECT COUNT(au) > 0 FROM AppUpdate au WHERE au.app.id = :appId AND au.version = :version")
    Boolean existsByAppIdAndVersion(@Param("appId") Long appId, @Param("version") String version);
    
    // Find updates with specific text in description
    @Query("SELECT au FROM AppUpdate au WHERE LOWER(au.updateDescription) LIKE LOWER(CONCAT('%', :text, '%'))")
    List<AppUpdate> findByDescriptionContaining(@Param("text") String text);
}
