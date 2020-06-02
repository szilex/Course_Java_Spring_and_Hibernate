package com.springcourse.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @RequestMapping("/processFormTwo")
    public String processFormToUpperCase(HttpServletRequest request, Model model) {

        String name = request.getParameter("studentName");
        name = name.toUpperCase();
        String result = "Hi! " + name;
        model.addAttribute("message", result);

        return "helloworld";
    }

    @RequestMapping("/processFormThree")
    public String processFormToUpperCaseWithParams(@RequestParam("studentName") String name, Model model) {

        name = name.toUpperCase();
        String result = "Hello " + name;
        model.addAttribute("message", result);

        return "helloworld";
    }
}
