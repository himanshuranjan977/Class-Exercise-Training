package com.gl.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gl.model.Category;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
    List<Category> findByNameContainingIgnoreCase(String name);
    Boolean existsByName(String name);
    List<Category> findByAppsId(Long appId);
    
    // Find categories with most apps
    @Query("SELECT c, COUNT(c.apps) as appCount FROM Category c GROUP BY c ORDER BY appCount DESC")
    List<Object[]> findCategoriesByAppCount();
    
    // Find categories by app visibility
    @Query("SELECT DISTINCT c FROM Category c JOIN c.apps a WHERE a.isVisible = true")
    List<Category> findCategoriesWithVisibleApps();
    
    // Find categories with at least a minimum number of apps
    @Query("SELECT c FROM Category c WHERE SIZE(c.apps) >= :minApps")
    List<Category> findCategoriesWithMinApps(@Param("minApps") int minApps);
}