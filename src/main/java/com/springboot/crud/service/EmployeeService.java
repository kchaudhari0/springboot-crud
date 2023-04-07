package com.springboot.crud.service;

import com.springboot.crud.Entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee saveEmployee(Employee theEmployee);

    void deleteById(int theId);
}
