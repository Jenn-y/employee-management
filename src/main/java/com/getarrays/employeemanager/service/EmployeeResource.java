package com.getarrays.employeemanager.service;

import java.util.List;

import com.getarrays.employeemanager.model.Employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
  private final EmployeeService employeeService;

  public EmployeeResource(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping("/all")
  public ResponseEntity<List<Employee>> getAllEmployees(){
    List<Employee> employees = employeeService.findAllEmployees();

    return ResponseEntity.status(HttpStatus.OK).body(employees);
  }

  @GetMapping("/find/{id}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
    Employee employee = employeeService.findEmployeeById(id);

    return ResponseEntity.status(HttpStatus.OK).body(employee);
  }
}
