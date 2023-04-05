package com.springboot.crud.dao;

import com.springboot.crud.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
