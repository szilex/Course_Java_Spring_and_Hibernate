package com.springcourse.springboot.SpringBootApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class IndexPageRestController {

    @Value("${team.coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World! Time on server is " + LocalDateTime.now();
    }

    @GetMapping("/workout")
    public String getWorkout() {
        return "It's time to go for a run";
    }

    @GetMapping("/fortune")
    public String getFortune() {
        return "Today will be a good day";
    }

    @GetMapping("/team-info")
    public String getTeamInfo() {
        return "The team is called " + teamName + " and it's coach is " + coachName;
    }
}
