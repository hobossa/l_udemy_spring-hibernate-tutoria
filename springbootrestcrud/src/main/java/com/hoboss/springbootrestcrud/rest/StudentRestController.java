package com.hoboss.springbootrestcrud.rest;

import com.hoboss.springbootrestcrud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    private void loadData() {
        students = new ArrayList<>();
        students.add(new Student("Steven", "He"));
        students.add(new Student("Uncle", "Roger"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        return students.get(studentId);
    }
}
