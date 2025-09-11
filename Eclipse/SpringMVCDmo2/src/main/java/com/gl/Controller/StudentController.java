package com.gl.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class StudentController {

    @RequestMapping("/student")
    public String testStudent(Model model) {

        Student s1 = new Student("Rani", 20);

        model.addAttribute("rani", s1);

        return "showstudent"; // showstudent.jsp
    }
    @RequestMapping("/student/list")
    public String testListStudent(Model model) {

        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("s1", 10));
        studentList.add(new Student("s2", 11));
        studentList.add(new Student("s3", 12));
        studentList.add(new Student("s4", 13));

        model.addAttribute("studentlist", studentList);

        return "showstudentlist"; // showstudentlist.jsp
    }
    
    @RequestMapping("/student/add")
    public String studentAddForm() {
        return "studentaddform"; // studentaddform.jsp
    }

    @PostMapping("/student/studentsave")
    public String studentSave(@RequestParam("name") String name,
                              @RequestParam("age") int age,
                              Model model) {

        Student s1 = new Student(name, age);

        String ageStatus = "Major";
        if (age < 18) {
            ageStatus = "Minor";
        }

        model.addAttribute("student", s1);
        model.addAttribute("ageStatus", ageStatus);

        return "studentdata"; // studentdata.jsp
    }
}
