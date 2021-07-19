package com.doxhost.spring.api.demo.rest;

import com.doxhost.spring.api.demo.entities.Student;
import com.doxhost.spring.api.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {


    private final StudentService studentService;

    @Autowired
    public StudentController( StudentService studentService ) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> fetchAllStudents(){
        return studentService.getAllStudents();
    }
}
