package com.gl.model;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "downloads")
public class Download {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "app_id", nullable = false)
    private App app;
    
    @Column(name = "downloaded_at")
    private LocalDateTime downloadedAt;
    
    // Constructors
    public Download() {}
    
    public Download(User user, App app) {
        this.user = user;
        this.app = app;
        this.downloadedAt = LocalDateTime.now();
    }
    
    // Getters and setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public App getApp() {
        return app;
    }
    
    public void setApp(App app) {
        this.app = app;
    }
    
    public LocalDateTime getDownloadedAt() {
        return downloadedAt;
    }
    
    public void setDownloadedAt(LocalDateTime downloadedAt) {
        this.downloadedAt = downloadedAt;
    }
    
    // PrePersist callback to set download time
    @PrePersist
    public void prePersist() {
        if (downloadedAt == null) {
            downloadedAt = LocalDateTime.now();
        }
    }
    
    // Equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Download download = (Download) o;
        
        return id != null ? id.equals(download.id) : download.id == null;
    }
    
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
    
    // toString
    @Override
    public String toString() {
        return "Download{" +
                "id=" + id +
                ", user=" + user.getUsername() +
                ", app=" + app.getName() +
                ", downloadedAt=" + downloadedAt +
                '}';
    }
}