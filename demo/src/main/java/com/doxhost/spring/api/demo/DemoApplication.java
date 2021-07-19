package com.doxhost.spring.api.demo;

import com.doxhost.spring.api.demo.entities.Address;
import com.doxhost.spring.api.demo.entities.Gender;
import com.doxhost.spring.api.demo.entities.Student;
import com.doxhost.spring.api.demo.repository.BaseEntityRepository;
import com.doxhost.spring.api.demo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner ( StudentRepository repository, MongoTemplate mongoTemplate ){
		return args ->{


			Address address = new Address( "Hungary", "Budapest", "1000" );
			String email = "demo@gmail.com";
			Student student = new Student(
					"David",
					"Furry",
					email,
					Gender.MALE,
					address,
					Arrays.asList( "Computer Science" ),
					BigDecimal.TEN,
					LocalDateTime.now()

			);


			Optional<Student> students = repository.findStudentByEmail( email );
			if ( students.isPresent() ){
				System.out.println( " already exists" );
			}else{
				repository.insert( student );

			}




			//usingMongoTemplateAndQuery( repository, mongoTemplate, email, student );

		};
	}

	private void usingMongoTemplateAndQuery( StudentRepository repository, MongoTemplate mongoTemplate, String email, Student student ) {
		Query query = new Query();
		query.addCriteria( Criteria.where( "email").is( email )  );

		List<Student> students = mongoTemplate.find( query,Student.class );

		if(students.size() >1){
				throw new IllegalStateException("found many students with email" + email );
		}

		if(students.isEmpty()){
			repository.insert( student );
		}
	}

}
