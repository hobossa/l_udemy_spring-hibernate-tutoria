package com.hoboss.springcoredemo.rest;

import com.hoboss.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    private Coach anotherCoach;

    @Autowired
    public void setMyCoach(@Qualifier("cricketCoach") Coach myCoach) {
        this.myCoach = myCoach;
    }

    @Autowired
    public void setAnotherCoach(@Qualifier("cricketCoach") Coach anotherCoach) {
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/check")
    public String check() {
        return "myCoach == anotherCoach:" + (this.myCoach == this.anotherCoach);
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
