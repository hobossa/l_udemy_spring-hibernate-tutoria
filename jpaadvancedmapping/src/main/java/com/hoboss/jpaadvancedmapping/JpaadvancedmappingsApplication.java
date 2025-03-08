package com.hoboss.jpaadvancedmapping;

import com.hoboss.jpaadvancedmapping.dao.AppDAO;
import com.hoboss.jpaadvancedmapping.entity.Course;
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
//			findInstructor(appDAO);
//			deleteInstructor(appDAO);
//			findInstructorDetail(appDAO);
//			deleteInstructorDetail(appDAO);
			createInstructorWithCourses(appDAO);
		};
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor = new Instructor(
				"Madhu", "Patel", "madhu@luv2code.com");
		InstructorDetail instructorDetail = new InstructorDetail(
				"http://youtube.com/madhu", "Guitar");
		instructor.setInstructorDetail(instructorDetail);
		Course course1 = new Course("Air Guitar - The Ultimate Guide");
		Course course2 = new Course("The Pinball Masterclass");
		instructor.add(course1);
		instructor.add(course2);

		System.out.println("Saving instructor: " + instructor);
		System.out.println("Instructor's details: " + instructorDetail);
		System.out.println("Instructor's courses: " + instructor.getCourses());
		// this will also save the courses and instructor details, because of CascadeType.PERSIST.
		appDAO.save(instructor);
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int id = 2;
		System.out.println("Deleting instructor detail id: " + id);
		appDAO.deleteInstructorDetailById(id);
		System.out.println("Done");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int id = 2;
		System.out.println("Finding instructor detail id: " + id);
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
		System.out.println("InstructorDetail: " + instructorDetail);
		System.out.println("The associated Instructor: " + instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Deleting instructor id: " + id);
		appDAO.deleteInstructorById(id);
		System.out.println("Done");
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
