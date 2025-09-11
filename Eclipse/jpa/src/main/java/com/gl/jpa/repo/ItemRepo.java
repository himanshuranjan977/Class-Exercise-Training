package com.gl.jpa.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gl.jpa.model.Item;

public interface ItemRepo extends JpaRepository<Item, Long> {

    // get the list of items by the category id
    List<Item> findByCategoryId(int categoryId);

    // get the list of items by the category id and more than given price
    List<Item> findByCategoryIdAndPriceGreaterThan(int categoryId, double price);

    // price > 
    List<Item> findByPriceGreaterThan(double price);

    // price >=
    List<Item> findByPriceGreaterThanEqual(double price);

    // filter by category id and arrange by name [A-Z]
    List<Item> findByCategoryIdOrderByNameAsc(int categoryId);

    // filter by category id and arrange by price in descending order
    List<Item> findByCategoryIdOrderByPriceDesc(int categoryId);

    // name must exactly match and is case sensitive
    List<Item> findByName(String name);

    // name must exactly match and is case insensitive
    List<Item> findByNameIgnoreCase(String name);
    
    // select * from item where name like %app%
    List<Item> findByNameContaining(String name);
    
    // select * from item where name like 'app%'
    List<Item> findByNameStartingWith(String name);

    // case-insensitive version
    List<Item> findByNameStartingWithIgnoreCase(String name);

    // select * from item where name like '%app'
    List<Item> findByNameEndingWith(String name);
    
    //find the item which has the most lowest price
    @Query("select min(price) from Item")
    Double FindMinPrice();
    
    //  Get item(s) with minimum price
    @Query("SELECT i FROM Item i WHERE i.price = (SELECT MIN(item.price) FROM Item item)")
    List<Item> findMinPriceItem();


    
    @Query("select sum(price) from Item")
    Double fintTotalPrice();
    
//  Get item(s) with maximum price
@Query("SELECT i FROM Item i WHERE i.price = (SELECT MAX(it.price) FROM Item it)")
List<Item> findMaxPriceItem();

    
@Query("SELECT i FROM Item i WHERE i.price = (SELECT MIN(it.price) FROM Item it WHERE it.category.id = :categoryId)")
List<Item> findMinPriceByCategory(int categoryId);








}
