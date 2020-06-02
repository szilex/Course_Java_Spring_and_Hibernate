package com.springcourse.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    //@Value("#{countryOptions}")
    //private Map<String, String> countryOptions;

    @RequestMapping("/showForm")
    public String showForm(Model model) {

        Student student = new Student();
        model.addAttribute("student", student);
        //model.addAttribute("theCountryOptions", countryOptions);

        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student) {
        System.out.println("Student first name: " + student.getFirstName());
        System.out.println("Student last name: "+ student.getLastName());
        System.out.println("Student country: " + student.getCountry());
        System.out.println("Favourite language: " + student.getLanguages());
        System.out.println("Operating systems: " + student.getOperatingSystems());
        return "student-confirmation";
    }
}
