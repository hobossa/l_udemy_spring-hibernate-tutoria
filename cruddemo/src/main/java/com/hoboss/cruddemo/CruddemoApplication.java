package com.hoboss.cruddemo;

import com.hoboss.cruddemo.dao.StudentDAO;
import com.hoboss.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating a new student ...");
		Student student = new Student("Jay", "P", "jay.p@gmail.com");
		System.out.println("Saving the student ...");
		studentDAO.save(student);
		// display id of the saved student
		System.out.println("Saved student. Generated id: " + student.getId());
	}
}
