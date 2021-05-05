package com.getarrays.employeemanager.model.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "job_title")
    private String jobTitle;
    @Column(name = "phone")
    private String phone;
    @Column(name = "image_url", nullable = true)
    private String imageUrl;
    @Column(name = "employee_code", nullable = false, updatable = false)
    private String employeeCode;

}