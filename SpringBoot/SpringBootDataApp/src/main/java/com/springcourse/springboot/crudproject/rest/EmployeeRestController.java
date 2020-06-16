package com.springcourse.springboot.crudproject.rest;

import com.springcourse.springboot.crudproject.entity.Employee;
import com.springcourse.springboot.crudproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeDAO) {
        this.employeeService = employeeDAO;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {

        Employee employee = employeeService.getEmployee(employeeId);

        if(employee == null) {
            throw new RuntimeException("Employee with id not fund - " + employeeId);
        }


        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

        employee.setId(0);
        employeeService.save(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int  employeeId) {
        Employee employee = employeeService.getEmployee(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee with id not fund - " + employeeId);
        }

        employeeService.delete(employeeId);

        return "Employee has been deleted";
    }
}
