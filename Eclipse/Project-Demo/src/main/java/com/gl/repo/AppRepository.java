package com.gl.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.model.App;

public interface AppRepository extends JpaRepository<App, Long> {
    List<App> findByNameContainingIgnoreCase(String name);
    List<App> findByCategoriesId(String categoryName);
    List<App> findByIsVisibleTrue();
    List<App> findByIsVisibleTrueAndRatingsGreaterThanEqual(Float minRating);
    List<App> findByOwnerId(Long ownerId);
	List<App> searchByNameOrDescription(String keyword);
	List<App> findByIsVisibleTrueOrderByReleaseDateDesc();
	List<App> findNewReleases();
	List<App> findPopularApps(Long minDownloads);
	List<Object[]> findAppsWithAverageRating();
}


