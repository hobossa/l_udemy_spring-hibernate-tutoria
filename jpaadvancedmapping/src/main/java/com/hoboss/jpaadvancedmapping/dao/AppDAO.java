package com.hoboss.jpaadvancedmapping.dao;

import com.hoboss.jpaadvancedmapping.entity.Instructor;
import com.hoboss.jpaadvancedmapping.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);
}
