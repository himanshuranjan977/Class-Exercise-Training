package com.gl.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.model.App;
import com.gl.model.Download;
import com.gl.model.User;
import com.gl.repo.AppRepository;
import com.gl.repo.DownloadRepository;
import com.gl.repo.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DownloadService {
    
    @Autowired
    private DownloadRepository downloadRepository;
    
    @Autowired
    private AppRepository appRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private NotificationService notificationService;
    
    public Download downloadApp(Long appId, User user) {
        App app = appRepository.findById(appId)
            .orElseThrow(() -> new RuntimeException("App not found"));
        
        if (!app.getIsVisible()) {
            throw new RuntimeException("App is not available for download");
        }
        
        // Check if user has already downloaded this app
        Optional<Download> existingDownload = downloadRepository.findByUserIdAndAppId(user.getId(), appId);
        if (existingDownload.isPresent()) {
            throw new RuntimeException("You have already downloaded this app");
        }
        
        Download download = new Download(user, app);
        Download savedDownload = downloadRepository.save(download);
        
        // Notify the app owner about the download
        notificationService.notifyUser(app.getOwner().getId(), 
            "App Downloaded", 
            "Your app '" + app.getName() + "' was downloaded by " + user.getUsername());
        
        return savedDownload;
    }
    
    public List<Download> getUserDownloads(Long userId) {
        return downloadRepository.findByUserId(userId);
    }
    
    public List<Download> getAppDownloads(Long appId) {
        return downloadRepository.findByAppId(appId);
    }
    
    public Long getDownloadCountByAppId(Long appId) {
        return downloadRepository.countByAppId(appId);
    }
    
    public Long getDownloadCountByUserId(Long userId) {
        return downloadRepository.countByUserId(userId);
    }
    
    public Long getDownloadCountByOwnerId(Long ownerId) {
        return downloadRepository.countByOwnerId(ownerId);
    }
    
    public List<Download> getDownloadsByOwnerId(Long ownerId) {
        return downloadRepository.findByOwnerId(ownerId);
    }
    
    public List<Object[]> getDownloadCountByApp() {
        return downloadRepository.findDownloadCountByApp();
    }
    
    public List<Object[]> getDownloadCountByUser() {
        return downloadRepository.findDownloadCountByUser();
    }
    
    public Long getDownloadsCountByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return downloadRepository.countByDateRange(startDate, endDate);
    }
    
    public Long getDownloadsCountByAppAndDateRange(Long appId, LocalDateTime startDate, LocalDateTime endDate) {
        return downloadRepository.countByAppIdAndDateRange(appId, startDate, endDate);
    }
    
    public boolean hasUserDownloadedFromOwner(Long userId, Long ownerId) {
        return downloadRepository.existsByUserIdAndOwnerId(userId, ownerId);
    }

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}