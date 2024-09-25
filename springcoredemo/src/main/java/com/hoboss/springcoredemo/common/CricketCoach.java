package com.hoboss.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!";
    }

    @PostConstruct
    public void doStartupStuff() {
        System.out.println("In doStartupStuff(): " + getClass().getSimpleName());
    }

    @PreDestroy
    public void doCleanStuff() {
        System.out.println("In doCleanStuff(): " + getClass().getSimpleName());
    }
}
