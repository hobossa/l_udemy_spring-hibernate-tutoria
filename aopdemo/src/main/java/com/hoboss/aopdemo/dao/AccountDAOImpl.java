package com.hoboss.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{
    private String name;

    @Override
    public void addAccount(String account) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    public void setName(String name) {
        this.name = name;
    }
}
