package com.gl.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.model.App;
import com.gl.model.AppUpdate;
import com.gl.model.User;
import com.gl.repo.AppRepository;
import com.gl.repo.AppUpdateRepository;


import java.util.List;
import java.util.Optional;

@Service
public class AppUpdateService {
    
    @Autowired
    private AppUpdateRepository appUpdateRepository;
    
    @Autowired
    private AppRepository appRepository;
    
    @Autowired
    private NotificationService notificationService;
    
    public AppUpdate createAppUpdate(Long appId, AppUpdate appUpdate, User owner) {
        App app = appRepository.findById(appId)
            .orElseThrow(() -> new RuntimeException("App not found"));
        
        if (!app.getOwner().getId().equals(owner.getId())) {
            throw new RuntimeException("You are not the owner of this app");
        }
        
        // Check if version already exists for this app
        if (appUpdateRepository.existsByAppIdAndVersion(appId, appUpdate.getVersion())) {
            throw new RuntimeException("This version already exists for this app");
        }
        
        appUpdate.setApp(app);
        AppUpdate savedUpdate = appUpdateRepository.save(appUpdate);
        
        // Notify all users who downloaded this app about the update
        notifyAppUsersAboutUpdate(appId, savedUpdate);
        
        return savedUpdate;
    }
    
    public AppUpdate updateAppUpdate(Long updateId, AppUpdate appUpdateDetails, User owner) {
        AppUpdate appUpdate = appUpdateRepository.findById(updateId)
            .orElseThrow(() -> new RuntimeException("App update not found"));
        
        if (!appUpdate.getApp().getOwner().getId().equals(owner.getId())) {
            throw new RuntimeException("You are not the owner of this app");
        }
        
        // Check if version already exists for this app (excluding current update)
        if (!appUpdate.getVersion().equals(appUpdateDetails.getVersion()) && 
            appUpdateRepository.existsByAppIdAndVersion(appUpdate.getApp().getId(), appUpdateDetails.getVersion())) {
            throw new RuntimeException("This version already exists for this app");
        }
        
        appUpdate.setVersion(appUpdateDetails.getVersion());
        appUpdate.setUpdateDescription(appUpdateDetails.getUpdateDescription());
        appUpdate.setReleaseDate(appUpdateDetails.getReleaseDate());
        
        return appUpdateRepository.save(appUpdate);
    }
    
    public void deleteAppUpdate(Long updateId, User owner) {
        AppUpdate appUpdate = appUpdateRepository.findById(updateId)
            .orElseThrow(() -> new RuntimeException("App update not found"));
        
        if (!appUpdate.getApp().getOwner().getId().equals(owner.getId())) {
            throw new RuntimeException("You are not the owner of this app");
        }
        
        appUpdateRepository.delete(appUpdate);
    }
    
    public List<AppUpdate> getAppUpdates(Long appId) {
        return appUpdateRepository.findByAppIdOrderByReleaseDateDesc(appId);
    }
    
    public List<AppUpdate> getAppUpdatesByOwnerId(Long ownerId) {
        return appUpdateRepository.findByOwnerId(ownerId);
    }
    
    public List<AppUpdate> getAppUpdatesByOwnerIdAndAppId(Long ownerId, Long appId) {
        return appUpdateRepository.findByOwnerIdAndAppId(ownerId, appId);
    }
    
    public Optional<AppUpdate> getAppUpdateByAppIdAndVersion(Long appId, String version) {
        return appUpdateRepository.findByAppIdAndVersion(appId, version);
    }
    
    public List<AppUpdate> getRecentUpdates(Long days) {
        return appUpdateRepository.findRecentUpdates(days);
    }
    
    public List<AppUpdate> getLatestUpdatesByOwnerId(Long ownerId) {
        return appUpdateRepository.findLatestUpdatesByOwnerId(ownerId);
    }
    
    public List<Object[]> getUpdateCountByApp() {
        return appUpdateRepository.countUpdatesByApp();
    }
    
    public List<AppUpdate> getUpdatesNewerThanVersion(Long appId, String version) {
        return appUpdateRepository.findUpdatesNewerThanVersion(appId, version);
    }
    
    public List<AppUpdate> searchUpdatesByDescription(String text) {
        return appUpdateRepository.findByDescriptionContaining(text);
    }
    
    private void notifyAppUsersAboutUpdate(Long appId, AppUpdate appUpdate) {
        App app = appRepository.findById(appId)
            .orElseThrow(() -> new RuntimeException("App not found"));
        
        String title = "App Update Available";
        String message = "A new update (v" + appUpdate.getVersion() + ") is available for '" + app.getName() + "'";
        
        // In a real application, you would notify users who have downloaded this app
        // For simplicity, we'll notify all users
        notificationService.notifyAllUsers(title, message);
        
        // Also notify the app owner
        notificationService.notifyUser(app.getOwner().getId(), 
            "Update Published", 
            "Your update for '" + app.getName() + "' (v" + appUpdate.getVersion() + ") has been published");
    }
}