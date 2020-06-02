package com.springcourse.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/basicForm")
public class FormController {

    @RequestMapping("/showForm")
    public String displayForm() {
        return "helloworld-form";
    }
}
