package com.hoboss.cruddemo.dao;

import com.hoboss.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
