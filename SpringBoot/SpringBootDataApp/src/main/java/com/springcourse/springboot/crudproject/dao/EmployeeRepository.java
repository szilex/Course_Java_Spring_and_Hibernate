package com.springcourse.springboot.crudproject.dao;

import com.springcourse.springboot.crudproject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
