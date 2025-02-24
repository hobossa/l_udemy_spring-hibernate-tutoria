package com.hoboss.jpaadvancedmapping;

import com.hoboss.jpaadvancedmapping.dao.AppDAO;
import com.hoboss.jpaadvancedmapping.entity.Instructor;
import com.hoboss.jpaadvancedmapping.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaadvancedmappingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaadvancedmappingsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
//			createInstructor(appDAO);
			findInstructor(appDAO);
		};
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor id: " + id);
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Instructor: " + instructor);
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor(
				"Madhu", "Patel", "madhu@luv2code.com");
		InstructorDetail instructorDetail = new InstructorDetail(
				"http://youtube.com/madhu", "Guitar");
		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving instructor: " + instructorDetail);
		appDAO.save(instructor);
		System.out.println("Done");
	}
}
