package com.gl.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.gl.model.App;

import com.gl.model.User;
import com.gl.service.AppService;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/apps")
public class AppController {
    
    @Autowired
    private AppService appService;
	private Object userService;
    
    @GetMapping
    public List<App> getAllApps() {
        return appService.getAllApps();
    }
    
    @GetMapping("/owner")
    public List<App> getAllAppsForOwner(@AuthenticationPrincipal User owner) {
        return appService.getAllAppsForOwner(owner);
    }
    
    @GetMapping("/owner/visible")
    public List<App> getVisibleAppsForOwner(@AuthenticationPrincipal User owner) {
        return appService.getVisibleAppsForOwner(owner);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getAppById(@PathVariable Long id) {
        try {
            Optional<App> app = appService.getVisibleAppById(id);
            if (app.isPresent()) {
                return ResponseEntity.ok(app.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/search")
    public List<App> searchApps(@RequestParam String name) {
        return appService.searchApps(name);
    }
    
    @GetMapping("/search/keyword")
    public List<App> searchAppsByNameOrDescription(@RequestParam String keyword) {
        return appService.searchAppsByNameOrDescription(keyword);
    }
    
    @GetMapping("/category/{categoryId}")
    public List<App> getAppsByCategory(@PathVariable Long categoryId) {
        return appService.getAppsByCategory(categoryId);
    }
    
    @GetMapping("/category/name/{categoryName}")
    public List<App> getAppsByCategoryName(@PathVariable String categoryName) {
        return appService.getAppsByCategoryName(categoryName);
    }
    
    @GetMapping("/filter/rating")
    public List<App> getAppsByRating(@RequestParam Float minRating) {
        return appService.getAppsByRating(minRating);
    }
    
    @GetMapping("/sort/name")
    public List<App> getAppsSortedByName() {
        return appService.getAppsSortedByName();
    }
    
    @GetMapping("/sort/rating")
    public List<App> getAppsSortedByRating() {
        return appService.getAppsSortedByRating();
    }
    
    @GetMapping("/sort/release-date")
    public List<App> getAppsSortedByReleaseDate() {
        return appService.getAppsSortedByReleaseDate();
    }
    
    @GetMapping("/new-releases")
    public List<App> getNewReleases() {
        return appService.getNewReleases();
    }
    
    @GetMapping("/popular")
    public List<App> getPopularApps(@RequestParam Long minDownloads) {
        return appService.getPopularApps(minDownloads);
    }
    
    @GetMapping("/stats/with-ratings")
    public List<Object[]> getAppsWithAverageRating() {
        return appService.getAppsWithAverageRating();
    }
    
    @PostMapping
    public ResponseEntity<?> createApp(@RequestBody App app, 
                                      @AuthenticationPrincipal User owner) {
        try {
            App createdApp = appService.createApp(app, owner);
            return ResponseEntity.ok(createdApp);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateApp(@PathVariable Long id, 
                                      @RequestBody App appDetails,
                                      @AuthenticationPrincipal User owner) {
        try {
            App updatedApp = appService.updateApp(id, appDetails, owner);
            return ResponseEntity.ok(updatedApp);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
   

    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteApp(@PathVariable Long id,
                                      @AuthenticationPrincipal User owner) {
        try {
            appService.deleteApp(id, owner);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PatchMapping("/{id}/visibility")
    public ResponseEntity<?> toggleAppVisibility(@PathVariable Long id,
                                                @AuthenticationPrincipal User owner) {
        try {
            App app = appService.toggleAppVisibility(id, owner);
            return ResponseEntity.ok(app);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/{id}/downloads/count")
    public ResponseEntity<?> getDownloadCount(@PathVariable Long id,
                                             @AuthenticationPrincipal User owner) {
        try {
            Long count = appService.getDownloadCount(id, owner);
            return ResponseEntity.ok(count);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/owner/downloads/count")
    public Long getTotalDownloadCountForOwner(@AuthenticationPrincipal User owner) {
        return appService.getTotalDownloadCountForOwner(owner);
    }
    
    @GetMapping("/owner/count")
    public List<App> getAppCountForOwner(@AuthenticationPrincipal User owner) {
        return appService.getAppCountForOwner(owner);
    }
    
    @GetMapping("/owner/average-rating")
    public Double getAverageRatingForOwner(@AuthenticationPrincipal User owner) {
        return appService.getAverageRatingForOwner(owner);
    }
    
    @GetMapping("/{id}/details")
    public ResponseEntity<?> getAppDetails(@PathVariable Long id) {
        try {
            Optional<App> app = appService.getVisibleAppById(id);
            if (app.isPresent()) {
                // In a real application, you might want to create a DTO with additional details
                // like download count, review count, etc.
                return ResponseEntity.ok(app.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

	public Object getUserService() {
		return userService;
	}

	public void setUserService(Object userService) {
		this.userService = userService;
	}
}
