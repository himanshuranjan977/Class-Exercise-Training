package com.gl.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gl.model.Review;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByUserId(Long userId);
    List<Review> findByAppId(Long appId);
    Optional<Review> findByUserIdAndAppId(Long userId, Long appId);
    List<Review> findByAppIdAndRatingGreaterThanEqual(Long appId, Integer minRating);
    List<Review> findByAppIdAndRatingLessThanEqual(Long appId, Integer maxRating);
    
    // Find reviews with comments (not null or empty)
    @Query("SELECT r FROM Review r WHERE r.comment IS NOT NULL AND LENGTH(r.comment) > 0")
    List<Review> findReviewsWithComments();
    
    // Find reviews for a specific app with comments
    @Query("SELECT r FROM Review r WHERE r.app.id = :appId AND r.comment IS NOT NULL AND LENGTH(r.comment) > 0")
    List<Review> findReviewsWithCommentsByAppId(@Param("appId") Long appId);
    
    // Calculate average rating for an app
    @Query("SELECT AVG(r.rating) FROM Review r WHERE r.app.id = :appId")
    Double findAverageRatingByAppId(@Param("appId") Long appId);
    
    // Count reviews for an app
    @Query("SELECT COUNT(r) FROM Review r WHERE r.app.id = :appId")
    Long countByAppId(@Param("appId") Long appId);
    
    // Count reviews by rating value for an app
    @Query("SELECT r.rating, COUNT(r) FROM Review r WHERE r.app.id = :appId GROUP BY r.rating ORDER BY r.rating DESC")
    List<Object[]> countByRatingForApp(@Param("appId") Long appId);
    
    // Find reviews for apps owned by a specific owner
    @Query("SELECT r FROM Review r WHERE r.app.owner.id = :ownerId")
    List<Review> findByOwnerId(@Param("ownerId") Long ownerId);
    
    // Find reviews for a specific app owned by a specific owner
    @Query("SELECT r FROM Review r WHERE r.app.owner.id = :ownerId AND r.app.id = :appId")
    List<Review> findByOwnerIdAndAppId(@Param("ownerId") Long ownerId, @Param("appId") Long appId);
    
    // Find recent reviews for an owner's apps
    @Query("SELECT r FROM Review r WHERE r.app.owner.id = :ownerId ORDER BY r.createdAt DESC")
    List<Review> findRecentReviewsByOwnerId(@Param("ownerId") Long ownerId);
    
    // Find highest rated reviews for an app
    @Query("SELECT r FROM Review r WHERE r.app.id = :appId ORDER BY r.rating DESC, r.createdAt DESC")
    List<Review> findTopRatedReviewsByAppId(@Param("appId") Long appId);
    
    // Find lowest rated reviews for an app
    @Query("SELECT r FROM Review r WHERE r.app.id = :appId ORDER BY r.rating ASC, r.createdAt DESC")
    List<Review> findLowestRatedReviewsByAppId(@Param("appId") Long appId);
}