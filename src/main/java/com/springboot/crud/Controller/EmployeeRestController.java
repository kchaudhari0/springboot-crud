package com.springboot.crud.Controller;

import com.springboot.crud.Entity.Employee;
import com.springboot.crud.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }


    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee Not found " + employeeId);
        }

        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);
        Employee newEmployee = employeeService.saveEmployee(theEmployee);

        return newEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deletedEmployee(@PathVariable int employeeId){

        employeeService.deleteById(employeeId);

        return "Delete was successful by ID " + employeeId ;
    }
}
