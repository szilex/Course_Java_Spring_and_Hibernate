package com.springcourse.springboot.thymeleaf.SpringBootThymeleafDemo.controller;

import com.springcourse.springboot.thymeleaf.SpringBootThymeleafDemo.entity.Employee;
import com.springcourse.springboot.thymeleaf.SpringBootThymeleafDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {

        model.addAttribute("employees", employeeService.getEmployees());

        return "employees/list-employees";
    }

    @GetMapping("/showAddForm")
    public String showAddForm(Model model) {

        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employees/add-form";
    }

    @GetMapping("/showUpdateForm")
    public String showUpdateForm(@RequestParam("employeeId") int id, Model model) {

        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);

        return "employees/add-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        employeeService.save(employee);

        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id) {

        employeeService.delete(id);

        return "redirect:/employees/list";
    }

    @GetMapping("/search")
    public String delete(@RequestParam("employeeName") String theName, Model theModel) {

        List<Employee> theEmployees = employeeService.searchBy(theName);
        theModel.addAttribute("employees", theEmployees);

        return "/employees/list-employees";
    }

}
