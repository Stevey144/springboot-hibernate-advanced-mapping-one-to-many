package com.luv2code.HibernateMappingDemo.Dao;

import com.luv2code.HibernateMappingDemo.entity.Instructor;
import com.luv2code.HibernateMappingDemo.entity.InstructorDetails;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //important so spring can find your class during component scanning
public class AppDaoImplementation implements AppDao{
    //define the field for entity manager
    private EntityManager entityManager;

    @Autowired
    public AppDaoImplementation( EntityManager entityManager){
        this.entityManager = entityManager;
    }

    // inject the field using constructor injection

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }
    @Override
    @Transactional
    public void deleteInstructor(int theId) {
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);
        entityManager.remove(tempInstructor);
    }

    @Override
    public InstructorDetails findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetails.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailsById(int theId) {
        InstructorDetails tempInstructorDetails = entityManager.find(InstructorDetails.class,theId);
        //remove the associated object reference
        // breaking the by-directional link
        tempInstructorDetails.getInstructor().setInstructorDetails(null);
        entityManager.remove(tempInstructorDetails);
    }

}
