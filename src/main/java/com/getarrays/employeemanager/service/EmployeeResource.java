package com.getarrays.employeemanager.service;

import java.util.List;

import com.getarrays.employeemanager.model.Employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
  EmployeeService employeeService;

  public EmployeeResource(final EmployeeService employeeService) {
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

  @PostMapping("/add")
  public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
    Employee newEmployee = employeeService.addEmployee(employee);

    return ResponseEntity.status(HttpStatus.CREATED).body(newEmployee);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
    Employee updatedEmployee = employeeService.updateEmployee(employee);

    return ResponseEntity.status(HttpStatus.OK).body(updatedEmployee);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
    employeeService.deleteEmployee(id);

    return new ResponseEntity<>(HttpStatus.OK);
  }
}
