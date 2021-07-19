package com.doxhost.spring.api.demo.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Document
public class Student extends BaseEntity{

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private Address address;
    private List<String> favouriteSubjects;
    private BigDecimal totalSpentInBook;
    private LocalDateTime created;

    public Student(
            String firstName,
            String lastName,
            String email,
            Gender gender,
            Address address,
            List<String> favouriteSubjects,
            BigDecimal totalSpentInBook,
            LocalDateTime created){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.favouriteSubjects = favouriteSubjects;
        this.totalSpentInBook = totalSpentInBook;
        this.created = created;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender( Gender gender ) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress( Address address ) {
        this.address = address;
    }

    public List<String> getFavouriteSubjects() {
        return favouriteSubjects;
    }

    public void setFavouriteSubjects( List<String> favouriteSubjects ) {
        this.favouriteSubjects = favouriteSubjects;
    }

    public BigDecimal getTotalSpentInBook() {
        return totalSpentInBook;
    }

    public void setTotalSpentInBook( BigDecimal totalSpentInBook ) {
        this.totalSpentInBook = totalSpentInBook;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated( LocalDateTime created ) {
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public void setId( String id ) {
        this.id = id;
    }


}
