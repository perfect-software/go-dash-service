package com.service.godash.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(schema = "ole",name="EmpUser")
public class User {

    private String FirstName;

    private String LastName;

    private String Email;

    private String Phone;

    private String DeptCode;
    private String Store;

}