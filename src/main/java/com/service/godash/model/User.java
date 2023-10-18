package com.service.godash.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="emp_user",schema = "ole")
public class User {

    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer EmployeeID;

//    @Column(name = "first_name")
//    private String FirstName;
//
//    @Column(name = "last_name")
//    private String LastName;
    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "userpass")
    private String password;

}