package com.gl.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.model.App;
import com.gl.model.Review;
import com.gl.model.User;
import com.gl.repo.AppRepository;
import com.gl.repo.ReviewRepository;
import com.gl.repo.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    
    @Autowired
    private ReviewRepository reviewRepository;
    
    @Autowired
    private AppRepository appRepository;
    
    @SuppressWarnings("unused")
	@Autowired
    private UserRepository userRepository;
    
    @Autowired
    private NotificationService notificationService;
    
    public Review createReview(Long appId, Review review, User user) {
        App app = appRepository.findById(appId)
            .orElseThrow(() -> new RuntimeException("App not found"));
        
        if (!app.getIsVisible()) {
            throw new RuntimeException("Cannot review an invisible app");
        }
        
        // Check if user has already reviewed this app
        Optional<Review> existingReview = reviewRepository.findByUserIdAndAppId(user.getId(), appId);
        if (existingReview.isPresent()) {
            throw new RuntimeException("You have already reviewed this app");
        }
        
        // Validate rating
        if (review.getRating() < 1 || review.getRating() > 5) {
            throw new RuntimeException("Rating must be between 1 and 5");
        }
        
        review.setUser(user);
        review.setApp(app);
        
        Review savedReview = reviewRepository.save(review);
        
        // Update app rating
        updateAppRating(appId);
        
        // Notify the app owner about the review
        notificationService.notifyUser(app.getOwner().getId(), 
            "New Review", 
            "Your app '" + app.getName() + "' received a new review from " + user.getUsername());
        
        return savedReview;
    }
    
    public Review updateReview(Long reviewId, Review reviewDetails, User user) {
        Review review = reviewRepository.findById(reviewId)
            .orElseThrow(() -> new RuntimeException("Review not found"));
        
        if (!review.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("You can only update your own reviews");
        }
        
        // Validate rating
        if (reviewDetails.getRating() < 1 || reviewDetails.getRating() > 5) {
            throw new RuntimeException("Rating must be between 1 and 5");
        }
        
        review.setRating(reviewDetails.getRating());
        review.setComment(reviewDetails.getComment());
        
        Review updatedReview = reviewRepository.save(review);
        
        // Update app rating
        updateAppRating(review.getApp().getId());
        
        return updatedReview;
    }
    
    public void deleteReview(Long reviewId, User user) {
        Review review = reviewRepository.findById(reviewId)
            .orElseThrow(() -> new RuntimeException("Review not found"));
        
        if (!review.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("You can only delete your own reviews");
        }
        
        Long appId = review.getApp().getId();
        reviewRepository.delete(review);
        
        // Update app rating
        updateAppRating(appId);
    }
    
    public List<Review> getReviewsByAppId(Long appId) {
        return reviewRepository.findByAppId(appId);
    }
    
    public List<Review> getReviewsByUserId(Long userId) {
        return reviewRepository.findByUserId(userId);
    }
    
    public List<Review> getReviewsByOwnerId(Long ownerId) {
        return reviewRepository.findByOwnerId(ownerId);
    }
    
    public List<Review> getReviewsByOwnerIdAndAppId(Long ownerId, Long appId) {
        return reviewRepository.findByOwnerIdAndAppId(ownerId, appId);
    }
    
    public Double getAverageRatingByAppId(Long appId) {
        return reviewRepository.findAverageRatingByAppId(appId);
    }
    
    public Long getReviewCountByAppId(Long appId) {
        return reviewRepository.countByAppId(appId);
    }
    
    public List<Object[]> getRatingDistributionByAppId(Long appId) {
        return reviewRepository.countByRatingForApp(appId);
    }
    
    public List<Review> getReviewsWithComments() {
        return reviewRepository.findReviewsWithComments();
    }
    
    public List<Review> getTopRatedReviewsByAppId(Long appId) {
        return reviewRepository.findTopRatedReviewsByAppId(appId);
    }
    
    public List<Review> getLowestRatedReviewsByAppId(Long appId) {
        return reviewRepository.findLowestRatedReviewsByAppId(appId);
    }
    
    private void updateAppRating(Long appId) {
        Double averageRating = reviewRepository.findAverageRatingByAppId(appId);
        if (averageRating != null) {
            App app = appRepository.findById(appId)
                .orElseThrow(() -> new RuntimeException("App not found"));
            app.setRatings(averageRating.floatValue());
            appRepository.save(app);
        }
    }
}
