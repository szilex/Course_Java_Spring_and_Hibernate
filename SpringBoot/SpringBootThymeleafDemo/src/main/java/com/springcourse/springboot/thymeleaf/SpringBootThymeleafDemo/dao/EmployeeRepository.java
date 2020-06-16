package com.springcourse.springboot.thymeleaf.SpringBootThymeleafDemo.dao;

import com.springcourse.springboot.thymeleaf.SpringBootThymeleafDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public List<Employee> findAllByOrderByLastNameAsc();

    public List<Employee> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);
}
