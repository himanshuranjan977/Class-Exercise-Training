package com.gl.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.model.App;

import com.gl.model.User;
import com.gl.repo.AppRepository;

import com.gl.repo.DownloadRepository;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AppService {
    
    @Autowired
    private AppRepository appRepository;
    
    @Autowired
    private DownloadRepository downloadRepository;
    
    @Autowired
    private NotificationService notificationService;
    
    public List<App> getAllApps() {
        return appRepository.findByIsVisibleTrue();
    }
    
    public List<App> getAllAppsForOwner(User owner) {
        return appRepository.findByOwnerId(owner.getId());
    }
    
    public List<App> getVisibleAppsForOwner(User owner) {
        return appRepository.findByOwnerId(owner.getId());
    }
    
    public Optional<App> getAppById(Long id) {
        return appRepository.findById(id);
    }
    
    public Optional<App> getVisibleAppById(Long id) {
        Optional<App> app = appRepository.findById(id);
        if (app.isPresent() && !app.get().getIsVisible()) {
            return Optional.empty();
        }
        return app;
    }
    
    public List<App> searchApps(String name) {
        return appRepository.findByNameContainingIgnoreCase(name);
    }
    
    public List<App> searchAppsByNameOrDescription(String keyword) {
        return appRepository.searchByNameOrDescription(keyword);
    }
    
    public List<App> getAppsByCategory(String categoryId) {
        return appRepository.findByCategoriesId(categoryId);
    }
    
    public List<App> getAppsByCategoryName(String categoryName) {
        return appRepository.findByCategoriesId(categoryName);
    }
    
    public List<App> getAppsByRating(Float minRating) {
        return appRepository.findByIsVisibleTrueAndRatingsGreaterThanEqual(minRating);
    }
    
    public List<App> getAppsSortedByName() {
        return appRepository.findByIsVisibleTrue();
    }
    
    public List<App> getAppsSortedByRating() {
        return appRepository.findByIsVisibleTrue();
    }
    
    public List<App> getAppsSortedByReleaseDate() {
        return appRepository.findByIsVisibleTrueOrderByReleaseDateDesc();
    }
    
    public List<App> getNewReleases() {
        return appRepository.findNewReleases();
    }
    
    public List<App> getPopularApps(Long minDownloads) {
        return appRepository.findPopularApps(minDownloads);
    }
    
    public List<Object[]> getAppsWithAverageRating() {
        return appRepository.findAppsWithAverageRating();
    }
    
    public App createApp(App app, User owner) {
        app.setOwner(owner);
        App savedApp = appRepository.save(app);
        
        // Notify all users about the new app
        notificationService.notifyAllUsers("New App Available", 
            "A new app '" + savedApp.getName() + "' has been added to the store.");
        
        return savedApp;
    }
    
    public App updateApp(Long id, App appDetails, User owner) {
        App app = appRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("App not found"));
        
        if (!app.getOwner().getId().equals(owner.getId())) {
            throw new RuntimeException("You are not the owner of this app");
        }
        
        app.setName(appDetails.getName());
        app.setDescription(appDetails.getDescription());
        app.setReleaseDate(appDetails.getReleaseDate());
        app.setVersion(appDetails.getVersion());
        app.setCategories(appDetails.getCategories());
        
        return appRepository.save(app);
    }
    
    public App updateAppCategories(Long id, Set<java.util.Locale.Category> categories, User owner) {
        App app = appRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("App not found"));
        
        if (!app.getOwner().getId().equals(owner.getId())) {
            throw new RuntimeException("You are not the owner of this app");
        }
        
        app.setCategories(categories);
        return appRepository.save(app);
    }
    
    public void deleteApp(Long id, User owner) {
        App app = appRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("App not found"));
        
        if (!app.getOwner().getId().equals(owner.getId())) {
            throw new RuntimeException("You are not the owner of this app");
        }
        
        appRepository.delete(app);
    }
    
    public App toggleAppVisibility(Long id, User owner) {
        App app = appRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("App not found"));
        
        if (!app.getOwner().getId().equals(owner.getId())) {
            throw new RuntimeException("You are not the owner of this app");
        }
        
        app.setIsVisible(!app.getIsVisible());
        return appRepository.save(app);
    }
    
    public Long getDownloadCount(Long appId, User owner) {
        App app = appRepository.findById(appId)
            .orElseThrow(() -> new RuntimeException("App not found"));
        
        if (!app.getOwner().getId().equals(owner.getId())) {
            throw new RuntimeException("You are not the owner of this app");
        }
        
        return downloadRepository.countByAppId(appId);
    }
    
    public Long getTotalDownloadCountForOwner(User owner) {
        return downloadRepository.countByOwnerId(owner.getId());
    }
    
    public List<App> getAppCountForOwner(User owner) {
        return appRepository.findByOwnerId(owner.getId());
    }
    
    public Double getAverageRatingForOwner(User owner) {
        List<App> ownerApps = appRepository.findByOwnerId(owner.getId());
        if (ownerApps.isEmpty()) {
            return 0.0;
        }
        
        double totalRating = 0;
        int ratedApps = 0;
        
        for (App app : ownerApps) {
            if (app.getRatings() > 0) {
                totalRating += app.getRatings();
                ratedApps++;
            }
        }
        
        return ratedApps > 0 ? totalRating / ratedApps : 0.0;
    }

	public List<App> getAppsByCategory(Long categoryId) {
		// TODO Auto-generated method stub
		return null;
	}
}
