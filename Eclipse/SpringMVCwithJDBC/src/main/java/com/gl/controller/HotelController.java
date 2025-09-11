package com.gl.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.controller.Hotel;

@Controller
public class HotelController {

    @RequestMapping("/")
    public String addHotelForm() {
        return "addhotel";  // JSP form page (/WEB-INF/views/addHotel.jsp)
    }
    @Autowired
    private HotelService service;
    
    @PostMapping("/savehotel")
    public String saveHotel(@RequestParam("name") String name,
                            @RequestParam("address") String address) {
        try {
            boolean status = service.addHotel(name, address);

            if (status) {
                return "insertsuccess";  // forwards to insertsuccess.jsp
            } else {
                return "insertfail";     // forwards to insertfail.jsp
            }
        } catch (Exception ex) {
            System.out.println("Error while saving hotel: " + ex.getMessage());
            return "insertfail";
        }
    }
    @RequestMapping("/hotel-list")
    public String readHotels(Model model) {
    	@SuppressWarnings("unchecked")
		List<Hotel> hotels = service.getAllHotels();

        if (hotels == null || hotels.isEmpty()) {
            return "hotellisterror"; // JSP for error handling
        } else {
            model.addAttribute("hotels", hotels);
            return "hotellist"; // JSP to display hotels
        }

    	

            
        }
    
        
    
}


