package com.hoboss.jpaadvancedmapping.dao;

import com.hoboss.jpaadvancedmapping.entity.Course;
import com.hoboss.jpaadvancedmapping.entity.Instructor;
import com.hoboss.jpaadvancedmapping.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {
    void saveInstructor(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);
    List<Course> findCoursesByInstructorId(int id);
    Instructor findInstructorByIdWithCourses(int id);
    void updateInstructor(Instructor instructor);
    Course findCourseById(int id);
    void updateCourse(Course course);
    void deleteCourseById(int id);
    void saveCourse(Course course);
    Course findCourseAndReviewsById(int id);
}
