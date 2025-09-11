package com.gl.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

    @RequestMapping("/welcome")
    public String forWelcome() {
        return "welcome"; // maps to /WEB-INF/views/welcome.jsp
    }

    @RequestMapping("/first")
    public String firstPage() {
        return "first";
    }
    
    @GetMapping("/add")
    public String add(@RequestParam("a") int a, 
                      @RequestParam("b") int b, Model model) {
        
        int c = a + b;   // addition logic
        System.out.println("C: " + c);
        model.addAttribute("answer",c);

        return "add"; // this should resolve to add.jsp (if using JSP)
    }
    
    @RequestMapping("/mul")
    public String showMulForm() {
        return "multiply"; // multiply.jsp
    }

    @PostMapping("/findmul")
    public String findmul(@RequestParam("a") int a,
                          @RequestParam("b") int b,
                          Model model) {

        int c = a * b;  // multiplication
        System.out.println("C: " + c);
        model.addAttribute("answer", c);

        return "mulanswer"; // mulanswer.jsp
    }

}

