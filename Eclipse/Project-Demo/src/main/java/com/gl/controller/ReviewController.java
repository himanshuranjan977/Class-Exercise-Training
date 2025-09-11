package com.gl.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.gl.model.Review;
import com.gl.model.User;
import com.gl.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    
    @Autowired
    private ReviewService reviewService;
    
    @PostMapping("/app/{appId}")
    public ResponseEntity<?> createReview(@PathVariable Long appId, 
                                         @RequestBody Review review,
                                         @AuthenticationPrincipal User user) {
        try {
            Review createdReview = reviewService.createReview(appId, review, user);
            return ResponseEntity.ok(createdReview);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PutMapping("/{reviewId}")
    public ResponseEntity<?> updateReview(@PathVariable Long reviewId, 
                                         @RequestBody Review reviewDetails,
                                         @AuthenticationPrincipal User user) {
        try {
            Review updatedReview = reviewService.updateReview(reviewId, reviewDetails, user);
            return ResponseEntity.ok(updatedReview);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?> deleteReview(@PathVariable Long reviewId,
                                         @AuthenticationPrincipal User user) {
        try {
            reviewService.deleteReview(reviewId, user);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/app/{appId}")
    public List<Review> getReviewsByAppId(@PathVariable Long appId) {
        return reviewService.getReviewsByAppId(appId);
    }
    
    @GetMapping("/user")
    public List<Review> getReviewsByUserId(@AuthenticationPrincipal User user) {
        return reviewService.getReviewsByUserId(user.getId());
    }
    
    @GetMapping("/owner")
    public List<Review> getReviewsByOwnerId(@AuthenticationPrincipal User owner) {
        return reviewService.getReviewsByOwnerId(owner.getId());
    }
    
    @GetMapping("/owner/app/{appId}")
    public List<Review> getReviewsByOwnerIdAndAppId(@AuthenticationPrincipal User owner,
                                                   @PathVariable Long appId) {
        return reviewService.getReviewsByOwnerIdAndAppId(owner.getId(), appId);
    }
    
    @GetMapping("/app/{appId}/average-rating")
    public Double getAverageRatingByAppId(@PathVariable Long appId) {
        return reviewService.getAverageRatingByAppId(appId);
    }
    
    @GetMapping("/app/{appId}/count")
    public Long getReviewCountByAppId(@PathVariable Long appId) {
        return reviewService.getReviewCountByAppId(appId);
    }
    
    @GetMapping("/app/{appId}/rating-distribution")
    public List<Object[]> getRatingDistributionByAppId(@PathVariable Long appId) {
        return reviewService.getRatingDistributionByAppId(appId);
    }
    
    @GetMapping("/with-comments")
    public List<Review> getReviewsWithComments() {
        return reviewService.getReviewsWithComments();
    }
    
    @GetMapping("/app/{appId}/top-rated")
    public List<Review> getTopRatedReviewsByAppId(@PathVariable Long appId) {
        return reviewService.getTopRatedReviewsByAppId(appId);
    }
    
    @GetMapping("/app/{appId}/lowest-rated")
    public List<Review> getLowestRatedReviewsByAppId(@PathVariable Long appId) {
        return reviewService.getLowestRatedReviewsByAppId(appId);
    }
    
    @GetMapping("/app/{appId}/user")
    public ResponseEntity<?> getUserReviewForApp(@PathVariable Long appId,
                                                @AuthenticationPrincipal User user) {
        try {
            // This would use a method to get a specific user's review for an app
            List<Review> userReviews = reviewService.getReviewsByUserId(user.getId())
                .stream()
                .filter(review -> review.getApp().getId().equals(appId))
                .toList();
            
            if (userReviews.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            
            return ResponseEntity.ok(userReviews.get(0));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}