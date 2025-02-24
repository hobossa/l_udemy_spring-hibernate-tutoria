package com.hoboss.jpaadvancedmapping.dao;

import com.hoboss.jpaadvancedmapping.entity.Instructor;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
}
