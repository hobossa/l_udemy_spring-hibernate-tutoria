package com.hoboss.cruddemo.service;

import com.hoboss.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(final Employee employee);

    void deleteById(int id);
}
