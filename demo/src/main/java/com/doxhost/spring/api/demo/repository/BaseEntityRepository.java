package com.doxhost.spring.api.demo.repository;

import com.doxhost.spring.api.demo.entities.BaseEntity;
import com.doxhost.spring.api.demo.entities.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BaseEntityRepository <T extends BaseEntity>  extends MongoRepository<Student,String> {

}
