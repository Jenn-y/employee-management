package com.getarrays.employeemanager.repo;

import java.util.List;
import java.util.Optional;

import com.getarrays.employeemanager.model.Employee;

public interface EmployeeRepo{

  void deleteEmployeeById(Long id);

  Employee save(Employee employee);

  List<Employee> findAll();

  Optional<Employee> findEmployeeById(Long id);
}
