package com.hoboss.cruddemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@Table(name = "student")
public class Student {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Getter
    @Setter
    @Column(name = "first_name")
    private String firstName;

    @Getter
    @Setter
    @Column(name = "last_name")
    private String lastName;

    @Getter
    @Setter
    @Column(name = "email")
    private String email;

    public Student() {
    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
