package com.doxhost.spring.api.demo.services;

import com.doxhost.spring.api.demo.entities.Student;
import com.doxhost.spring.api.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {


    private final StudentRepository studentRepository;

    @Autowired
    public StudentService( StudentRepository studentRepository ) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){

        return studentRepository.findAll();
    }



}
