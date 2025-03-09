package com.hoboss.jpaadvancedmapping;

import com.hoboss.jpaadvancedmapping.dao.AppDAO;
import com.hoboss.jpaadvancedmapping.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
//			createInstructorWithCourses(appDAO);
//			findInstructorWithCourses(appDAO);
//			findCourseForInstructor(appDAO);
//			findInstructorWithCoursesEx(appDAO);
//			updateInstructor(appDAO);
//			updateCourse(appDAO);
//			createCourseAndReviews(appDAO);
			createCourseAndStudents(appDAO);
		};
	}

	private void createCourseAndStudents(AppDAO appDAO) {
		Course course = new Course("Pacman - How To Java");
		course.addStudent(new Student("John", "Doe", "john@gmail.com"));
		course.addStudent(new Student("Mary", "Public", "mary@gmail.com"));
		appDAO.saveCourse(course);
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		Course course = new Course("Pacman - How To Java");
		course.addReview(new Review("Great course ... loved it!"));
		course.addReview(new Review("Cool course, job well done"));
		course.addReview(new Review("What a dumb course, you are an idiot!"));

		System.out.println("Saving course: " + course);
		System.out.println("Course's reviews: " + course.getReviews());
		appDAO.saveCourse(course);
		System.out.println("Done");
	}

	private void updateCourse(AppDAO appDAO) {
		int id = 10;
		System.out.println("Finding course id: " + id);
		Course course = appDAO.findCourseById(id);
		course.setTitle(course.getTitle().toUpperCase());
		appDAO.updateCourse(course);
	}

	private void updateInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor id: " + id);
		Instructor instructor = appDAO.findInstructorById(id);
		instructor.setLastName("Smith");
		appDAO.updateInstructor(instructor);
		System.out.println("Done");
	}

	// JOIN FETCH
	private void findInstructorWithCoursesEx(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor with courses id: " + id);
		Instructor instructor = appDAO.findInstructorByIdWithCourses(id);
		System.out.println("Instructor: " + instructor);
		System.out.println("Instructor's courses: " + instructor.getCourses());
	}

	// fetch = FetchType.LAZY,
	private void findCourseForInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor with courses id: " + id);
		Instructor instructor = appDAO.findInstructorById(id);
		List<Course> courses = appDAO.findCoursesByInstructorId(id);
		// the instructor's courses are not loaded yet, because of FetchType.LAZY.
		// so we need to set the courses manually.
		instructor.setCourses(courses);
		System.out.println("Instructor: " + instructor);
		System.out.println("Instructor's courses: " + instructor.getCourses());
	}

	// fetch = FetchType.EAGER
	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor with courses id: " + id);
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Instructor: " + instructor);
		System.out.println("Instructor's courses: " + instructor.getCourses());
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
		appDAO.saveInstructor(instructor);
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
		appDAO.saveInstructor(instructor);
		System.out.println("Done");
	}
}
