package com.getarrays.employeemanager.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Employee implements Serializable {
  private Long id;
  private String name;
  private String email;
  private String jobTitle;
  private String phone;
  private String imageUrl;
  private String employeeCode;
}
