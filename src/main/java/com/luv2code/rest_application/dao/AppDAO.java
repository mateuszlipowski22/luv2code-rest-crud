package com.luv2code.rest_application.dao;

import com.luv2code.rest_application.entity.Course;
import com.luv2code.rest_application.entity.Instructor;
import com.luv2code.rest_application.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailsById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCourseByInstructor(int id);
}
