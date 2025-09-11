package com.gl.model;


import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;



@Entity
@Table(name = "app_updates")
public class AppUpdate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "app_id", nullable = false)
    private App app;
    
    @Column(nullable = false)
    private String version;
    
    @Column(name = "update_description", nullable = false)
    private String updateDescription;
    
    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    // Constructors
    public AppUpdate() {}
    
    public AppUpdate(App app, String version, String updateDescription, LocalDate releaseDate) {
        this.app = app;
        this.version = version;
        this.updateDescription = updateDescription;
        this.releaseDate = releaseDate;
        this.createdAt = LocalDateTime.now();
    }
    
    // Getters and setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public App getApp() {
        return app;
    }
    
    public void setApp(App app) {
        this.app = app;
    }
    
    public String getVersion() {
        return version;
    }
    
    public void setVersion(String version) {
        this.version = version;
    }
    
    public String getUpdateDescription() {
        return updateDescription;
    }
    
    public void setUpdateDescription(String updateDescription) {
        this.updateDescription = updateDescription;
    }
    
    public LocalDate getReleaseDate() {
        return releaseDate;
    }
    
    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    // PrePersist callback
    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }
    
    // Equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        AppUpdate appUpdate = (AppUpdate) o;
        
        return id != null ? id.equals(appUpdate.id) : appUpdate.id == null;
    }
    
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
    
    // toString
    @Override
    public String toString() {
        return "AppUpdate{" +
                "id=" + id +
                ", app=" + app.getName() +
                ", version='" + version + '\'' +
                ", updateDescription='" + updateDescription + '\'' +
                ", releaseDate=" + releaseDate +
                ", createdAt=" + createdAt +
                '}';
    }
}