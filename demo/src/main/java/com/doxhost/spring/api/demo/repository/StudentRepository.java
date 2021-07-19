package com.doxhost.spring.api.demo.repository;

import com.doxhost.spring.api.demo.entities.Student;
import java.util.Optional;

public interface StudentRepository extends  BaseEntityRepository<Student>{

    Optional<Student> findStudentByEmail(String email);
}
