package com.hoboss.jpaadvancedmapping.dao;

import com.hoboss.jpaadvancedmapping.entity.Course;
import com.hoboss.jpaadvancedmapping.entity.Instructor;
import com.hoboss.jpaadvancedmapping.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);
    List<Course> findCoursesByInstructorId(int id);
    Instructor findInstructorByIdWithCourses(int id);
}
