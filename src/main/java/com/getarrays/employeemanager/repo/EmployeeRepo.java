package com.getarrays.employeemanager.repo;

import java.util.Optional;

import com.getarrays.employeemanager.model.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
  Optional<Employee> findEmployeeById(Long id);
}
