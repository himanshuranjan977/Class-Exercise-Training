package com.gl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SimcardController {

    @Autowired
    private SimcardService service;

    // Show form to add simcard
    @GetMapping("/addsimcard")
    public String showAddForm() {
        // This will be resolved as /WEB-INF/view/addsimcard.jsp
        return "addsimcard";
    }

    // Handle form submission
    @PostMapping("/savesimcard")
    public String saveSimcard(@RequestParam("company") String company,
                              @RequestParam("planName") String planName,
                              Model model) {
        boolean status = service.addSimcard(company, planName);

        if (status) {
            model.addAttribute("message", "Simcard inserted successfully!");
            return "insertsuccess";   // -> /WEB-INF/view/insertsuccess.jsp
        } else {
            model.addAttribute("message", "Failed to insert simcard.");
            return "insertfail";      // -> /WEB-INF/view/insertfail.jsp
        }
    }

    // List all simcards
    @GetMapping("/listsimcards")
    public String listSimcards(Model model) {
        List<Simcard> simcards = service.getAllSimcards();
        model.addAttribute("simcards", simcards);
        return "listsimcards";   // -> /WEB-INF/view/listsimcards.jsp
    }
}

