package com.gl.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.gl.model.Download;
import com.gl.model.User;
import com.gl.service.DownloadService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/downloads")
public class DownloadController {
    
    @Autowired
    private DownloadService downloadService;
    
    @PostMapping("/app/{appId}")
    public ResponseEntity<?> downloadApp(@PathVariable Long appId, 
    		@AuthenticationPrincipal User user) {
        try {
            Download download = downloadService.downloadApp(appId, user);
            return ResponseEntity.ok(download);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/user")
    public List<Download> getUserDownloads(@AuthenticationPrincipal User user) {
        return downloadService.getUserDownloads(user.getId());
    }
    
    @GetMapping("/app/{appId}")
    public List<Download> getAppDownloads(@PathVariable Long appId) {
        return downloadService.getAppDownloads(appId);
    }
    
    @GetMapping("/app/{appId}/count")
    public Long getDownloadCountByAppId(@PathVariable Long appId) {
        return downloadService.getDownloadCountByAppId(appId);
    }
    
    @GetMapping("/user/count")
    public Long getDownloadCountByUserId(@AuthenticationPrincipal User user) {
        return downloadService.getDownloadCountByUserId(user.getId());
    }
    
    @GetMapping("/owner/count")
    public Long getDownloadCountByOwnerId(@AuthenticationPrincipal User owner) {
        return downloadService.getDownloadCountByOwnerId(owner.getId());
    }
    
    @GetMapping("/owner")
    public List<Download> getDownloadsByOwnerId(@AuthenticationPrincipal User owner) {
        return downloadService.getDownloadsByOwnerId(owner.getId());
    }
    
    @GetMapping("/stats/by-app")
    public List<Object[]> getDownloadCountByApp() {
        return downloadService.getDownloadCountByApp();
    }
    
    @GetMapping("/stats/by-user")
    public List<Object[]> getDownloadCountByUser() {
        return downloadService.getDownloadCountByUser();
    }
    
    @GetMapping("/stats/date-range")
    public ResponseEntity<?> getDownloadsCountByDateRange(
            @RequestParam String startDate, 
            @RequestParam String endDate) {
        try {
            LocalDateTime start = LocalDateTime.parse(startDate);
            LocalDateTime end = LocalDateTime.parse(endDate);
            Long count = downloadService.getDownloadsCountByDateRange(start, end);
            return ResponseEntity.ok(count);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/stats/app/{appId}/date-range")
    public ResponseEntity<?> getDownloadsCountByAppAndDateRange(
            @PathVariable Long appId,
            @RequestParam String startDate, 
            @RequestParam String endDate) {
        try {
            LocalDateTime start = LocalDateTime.parse(startDate);
            LocalDateTime end = LocalDateTime.parse(endDate);
            Long count = downloadService.getDownloadsCountByAppAndDateRange(appId, start, end);
            return ResponseEntity.ok(count);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/check/owner/{ownerId}")
    public Boolean hasUserDownloadedFromOwner(@AuthenticationPrincipal User user, 
                                             @PathVariable Long ownerId) {
        return downloadService.hasUserDownloadedFromOwner(user.getId(), ownerId);
    }
}