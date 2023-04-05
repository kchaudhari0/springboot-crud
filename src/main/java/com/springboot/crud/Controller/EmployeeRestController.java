package com.springboot.crud.Controller;

import com.springboot.crud.Entity.Employee;
import com.springboot.crud.dao.EmployeeDAO;
import com.springboot.crud.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService=theEmployeeService;
    }


    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId)
    {
        Employee theEmployee= employeeService.findByID(employeeId);

        if(theEmployee==null)
        {
            throw new RuntimeException("Employee Not found "+ employeeId);
        }

        return theEmployee;
    }
}
