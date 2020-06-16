package com.springcourse.springboot.crudproject.dao;

import com.springcourse.springboot.crudproject.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getEmployees();

    public Employee getEmployee(int id);

    public void save(Employee employee);

    public void delete(int id);
}
