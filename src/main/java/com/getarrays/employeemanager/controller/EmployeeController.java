package com.getarrays.employeemanager.controller;

import java.util.Collection;

import com.getarrays.employeemanager.model.dto.EmployeeDTO;
import com.getarrays.employeemanager.service.EmployeeService;

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

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
  private final EmployeeService employeeService;

  @GetMapping
  public ResponseEntity<Collection<EmployeeDTO>> getAllEmployees(){
    Collection<EmployeeDTO> employees = employeeService.findAllEmployees();

    return ResponseEntity.status(HttpStatus.OK).body(employees);
  }

  @GetMapping("/find/{id}")
  public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long id){
    EmployeeDTO employee = employeeService.findEmployeeById(id);

    return ResponseEntity.status(HttpStatus.OK).body(employee);
  }

  @PostMapping("/add")
  public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employee){
    EmployeeDTO newEmployee = employeeService.addEmployee(employee);

    return ResponseEntity.status(HttpStatus.CREATED).body(newEmployee);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<EmployeeDTO> updateEmployee(
    @PathVariable Long id,
    @RequestBody EmployeeDTO employee){
    EmployeeDTO updatedEmployee = employeeService.updateEmployee(id, employee);

    return ResponseEntity.status(HttpStatus.OK).body(updatedEmployee);
  }

  @DeleteMapping("/delete/{id}")
  public void deleteEmployee(@PathVariable("id") Long id){
    employeeService.deleteEmployee(id);
  }
}
