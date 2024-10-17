package com.hoboss.cruddemo.dao;

import com.hoboss.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(final Employee employee);

    void deleteById(int id);
}
