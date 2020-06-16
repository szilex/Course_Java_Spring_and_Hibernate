package com.springcourse.springboot.thymeleaf.SpringBootThymeleafDemo.service;


import com.springcourse.springboot.thymeleaf.SpringBootThymeleafDemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getEmployees();

    public Employee getEmployee(int id);

    public void save(Employee employee);

    public void delete(int id);

    public List<Employee> searchBy(String theName);
}
