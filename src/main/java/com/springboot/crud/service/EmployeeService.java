package com.springboot.crud.service;

import com.springboot.crud.Entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
}
