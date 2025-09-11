package com.gl.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.jpa.model.Category;
import com.gl.jpa.model.Item;
import com.gl.jpa.repo.ItemRepo;

@Service
public class ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private CategoryService categoryService;

    //  Add new item
    public Item add(String name, double price, int categoryId) {
        Category category = categoryService.findById(categoryId);
        if (category == null) {
            return null;
        }
        Item item = new Item(name, price, category);
        return itemRepo.save(item);
    }
    //  Get the list of items by the category id
    public List<Item> findByCategoryId(int categoryId) {
        Category category = categoryService.findById(categoryId);
        if (category == null) {
            return null; 
        }
        return itemRepo.findByCategoryId(categoryId);
    }
    public List<Item> findByCategoryIdAndPriceGreaterThan(int categoryId, double price) {
		Category category = categoryService.findById(categoryId);
		if (category == null) {
			return null;
		}
		return itemRepo.findByCategoryIdAndPriceGreaterThan(categoryId, price);
	}
    
    public double findMinPrice() {
        return itemRepo.FindMinPrice();
    }

    public List<Item> findItemsByMinPrice() {
        return itemRepo.findMinPriceItem();
    }
    public List<Item> findMinPriceByCategory(int categoryId) {
        return itemRepo.findMinPriceByCategory(categoryId);
    }




 


}

