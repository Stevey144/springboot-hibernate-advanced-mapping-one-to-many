package com.luv2code.HibernateMappingDemo.Dao;

import com.luv2code.HibernateMappingDemo.entity.Instructor;
import com.luv2code.HibernateMappingDemo.entity.InstructorDetails;

public interface AppDao {

    void save(Instructor Instructor);
    Instructor findInstructorById(int theId);
    void deleteInstructor(int theId);
    InstructorDetails findInstructorDetailById(int theId);
    void deleteInstructorDetailsById(int theId);

}
