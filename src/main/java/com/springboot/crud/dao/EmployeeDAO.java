package com.springboot.crud.dao;

import com.springboot.crud.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findByID(int theId);

    Employee saveEmployee(Employee theEmployee);

    void deleteById(int theId);
}
