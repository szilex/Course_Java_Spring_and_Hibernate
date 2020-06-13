package com.springcourse.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String diplayHomePage() {
        return "home";
    }

    @GetMapping("/leaders")
    public String displayLeadersPage() {
        return "leaders";
    }

    @GetMapping("/systems")
    public String displaySystemsPage() {
        return "systems";
    }

}
