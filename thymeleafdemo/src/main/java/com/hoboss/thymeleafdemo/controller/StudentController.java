package com.hoboss.thymeleafdemo.controller;

import com.hoboss.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @GetMapping("/showForm")
    public String showForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);

        model.addAttribute("countries", countries);
        return "student-form";
    }

    @PostMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student) {

        return "student-confirmation";
    }
}
