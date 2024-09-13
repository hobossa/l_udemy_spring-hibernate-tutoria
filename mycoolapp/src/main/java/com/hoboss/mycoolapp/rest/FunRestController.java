package com.hoboss.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${spring.application.name}")
    private String appName;

    // expose "/" that return "Hello World"
    @GetMapping("/")
    public String sayHello() {
        return appName + ": Hello World!";
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 500k!";
    }

    @GetMapping("/fortune")
    public String getFortune() {
        return "Today is your lucky day.";
    }
}
