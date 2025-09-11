package com.gl.jpa.controller;

import com.gl.jpa.model.Category;
import com.gl.jpa.model.Item;
import com.gl.jpa.service.CategoryService;
import com.gl.jpa.service.ItemService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/ecom") // common prefix for all endpoints
public class EcommerceController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ItemService itemService;

    // ✅ Add Category
    @PostMapping("/categories")
    public ResponseEntity<?> addCategory(@RequestParam String name) {
        Category category = categoryService.add(name);

        if (category == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error: Category could not be added");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    // ✅ Add Item
    @PostMapping("/items")
    public ResponseEntity<?> addItem(@RequestParam String name,
                                     @RequestParam double price,
                                     @RequestParam int categoryId) {
        Item item = itemService.add(name, price, categoryId);

        if (item == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error: Item could not be added (check categoryId)");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }
    @GetMapping("/ecom/item/bycategoryid")
    public ResponseEntity filterByCategoryId(@RequestParam int categoryId) {
        List<Item> items = itemService.findByCategoryId(categoryId);
        return ResponseEntity.status(HttpStatus.OK).body(items);
    }
    @GetMapping("/ecom/item/minprice")
    public ResponseEntity findMinPrice() {
        return ResponseEntity.status(HttpStatus.OK)
                .body("The Minimum price is: " + itemService.findMinPrice());
    }
    
    @GetMapping("/ecom/item/minpricelist")
    public ResponseEntity findMinPriceList() {
        List<Item> items = itemService.findItemsByMinPrice();
        return ResponseEntity.status(HttpStatus.OK).body(items);
    }

    
    
}
