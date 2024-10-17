package com.hoboss.cruddemo.rest;

import com.hoboss.cruddemo.entity.Employee;
import com.hoboss.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        final Employee employee = employeeService.findById(employeeId);
        if (null == employee) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PostMapping("/employees")
    Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);  // id == 0 will do inserting instead of updating
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    String deleteEmployee(@PathVariable int employeeId) {
        final Employee employee = employeeService.findById(employeeId);
        if (null == employee) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Delete employee id - " + employeeId;
    }
}
