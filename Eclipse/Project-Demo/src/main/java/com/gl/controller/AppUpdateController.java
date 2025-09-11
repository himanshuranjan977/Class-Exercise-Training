package com.gl.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.gl.model.AppUpdate;
import com.gl.model.User;
import com.gl.service.AppUpdateService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/app-updates")
public class AppUpdateController {
    
    @Autowired
    private AppUpdateService appUpdateService;
    
    @PostMapping("/app/{appId}")
    public ResponseEntity<?> createAppUpdate(@PathVariable Long appId, 
                                            @RequestBody AppUpdate appUpdate,
                                            @AuthenticationPrincipal User owner) {
        try {
            AppUpdate createdUpdate = appUpdateService.createAppUpdate(appId, appUpdate, owner);
            return ResponseEntity.ok(createdUpdate);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PutMapping("/{updateId}")
    public ResponseEntity<?> updateAppUpdate(@PathVariable Long updateId, 
                                            @RequestBody AppUpdate appUpdateDetails,
                                            @AuthenticationPrincipal User owner) {
        try {
            AppUpdate updatedUpdate = appUpdateService.updateAppUpdate(updateId, appUpdateDetails, owner);
            return ResponseEntity.ok(updatedUpdate);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @DeleteMapping("/{updateId}")
    public ResponseEntity<?> deleteAppUpdate(@PathVariable Long updateId,
                                            @AuthenticationPrincipal User owner) {
        try {
            appUpdateService.deleteAppUpdate(updateId, owner);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/app/{appId}")
    public List<AppUpdate> getAppUpdates(@PathVariable Long appId) {
        return appUpdateService.getAppUpdates(appId);
    }
    
    @GetMapping("/owner")
    public List<AppUpdate> getAppUpdatesByOwnerId(@AuthenticationPrincipal User owner) {
        return appUpdateService.getAppUpdatesByOwnerId(owner.getId());
    }
    
    @GetMapping("/owner/app/{appId}")
    public List<AppUpdate> getAppUpdatesByOwnerIdAndAppId(@AuthenticationPrincipal User owner,
                                                         @PathVariable Long appId) {
        return appUpdateService.getAppUpdatesByOwnerIdAndAppId(owner.getId(), appId);
    }
    
    @GetMapping("/app/{appId}/version/{version}")
    public ResponseEntity<?> getAppUpdateByAppIdAndVersion(@PathVariable Long appId,
                                                          @PathVariable String version) {
        try {
            Optional<AppUpdate> appUpdate = appUpdateService.getAppUpdateByAppIdAndVersion(appId, version);
            if (appUpdate.isPresent()) {
                return ResponseEntity.ok(appUpdate.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/recent/{days}")
    public List<AppUpdate> getRecentUpdates(@PathVariable Long days) {
        return appUpdateService.getRecentUpdates(days);
    }
    
    @GetMapping("/owner/latest")
    public List<AppUpdate> getLatestUpdatesByOwnerId(@AuthenticationPrincipal User owner) {
        return appUpdateService.getLatestUpdatesByOwnerId(owner.getId());
    }
    
    @GetMapping("/stats/by-app")
    public List<Object[]> getUpdateCountByApp() {
        return appUpdateService.getUpdateCountByApp();
    }
    
    @GetMapping("/app/{appId}/newer-than/{version}")
    public List<AppUpdate> getUpdatesNewerThanVersion(@PathVariable Long appId,
                                                     @PathVariable String version) {
        return appUpdateService.getUpdatesNewerThanVersion(appId, version);
    }
    
    @GetMapping("/search")
    public List<AppUpdate> searchUpdatesByDescription(@RequestParam String text) {
        return appUpdateService.searchUpdatesByDescription(text);
    }
    
    @GetMapping("/app/{appId}/latest")
    public ResponseEntity<?> getLatestAppUpdate(@PathVariable Long appId) {
        try {
            List<AppUpdate> updates = appUpdateService.getAppUpdates(appId);
            if (updates.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(updates.get(0)); // First one is latest due to sorting
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
