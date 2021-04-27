package com.getarrays.employeemanager.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
  name = "employees"
)
@Getter
@Setter
@NoArgsConstructor
public class Employees extends EntityWithLongId {
  @Column(name = "name")
  private String name;
  @Column(name = "email")
  private String email;
  @Column(name = "job_title")
  private String jobTitle;
  @Column(name = "phone")
  private String phone;
  @Column(name = "image_url", nullable = false)
  private String imageUrl;
}
