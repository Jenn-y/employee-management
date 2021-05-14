package com.getarrays.employeemanager.service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.getarrays.employeemanager.model.dto.EmployeeDTO;
import com.getarrays.employeemanager.model.entity.Employee;
import com.getarrays.employeemanager.repo.EmployeeRepo;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {
  private final EmployeeRepo employeeRepo;

  public EmployeeDTO addEmployee(EmployeeDTO payload){
    Employee employee = fromPayload(payload);
    employee.setEmployeeCode(UUID.randomUUID().toString());
    employee = employeeRepo.save(employee);
    return toPayload(employee);
  }

  public Collection<EmployeeDTO> findAllEmployees(){
    return employeeRepo.findAll().stream().map(this::toPayload).collect(Collectors.toList());
  }

  public EmployeeDTO findEmployeeById(Long id){
    Optional<Employee> employee = employeeRepo.findEmployeeById(id);
    if (employee.isPresent()) return toPayload(employee.get());
    throw new RuntimeException("Employee with id " + id + " does not exist!");
 }

  public EmployeeDTO updateEmployee(Long id, EmployeeDTO payload){
    findEmployeeById(id);
    
    Employee employee = fromPayload(payload);
    employee.setId(id);
    employee = employeeRepo.save(employee);
    return toPayload(employee);
  }

  public void deleteEmployee(Long id){
    employeeRepo.deleteById(id);
  }

  private Employee fromPayload(EmployeeDTO payload) {
    Employee employee = new Employee();
    employee.setName(payload.getName());
    employee.setEmail(payload.getEmail());
    employee.setJobTitle(payload.getJobTitle());
    employee.setPhone(payload.getPhone());
    employee.setImageUrl(payload.getImageUrl());
    employee.setEmployeeCode(payload.getEmployeeCode());
    return employee;
  }

  private EmployeeDTO toPayload(Employee employee) {
    EmployeeDTO payload = new EmployeeDTO();
    payload.setId(employee.getId());
    payload.setName(employee.getName());
    payload.setEmail(employee.getEmail());
    payload.setJobTitle(employee.getJobTitle());
    payload.setPhone(employee.getPhone());
    payload.setImageUrl(employee.getImageUrl());
    payload.setEmployeeCode(employee.getEmployeeCode());
    return payload;
  }
}
