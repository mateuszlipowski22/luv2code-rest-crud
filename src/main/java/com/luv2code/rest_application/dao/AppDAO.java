package com.luv2code.rest_application.dao;

import com.luv2code.rest_application.entity.Course;
import com.luv2code.rest_application.entity.Instructor;
import com.luv2code.rest_application.entity.InstructorDetail;
import com.luv2code.rest_application.entity.Student;

import java.util.List;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    Course findCourseById(int id);

    void deleteInstructorById(int id);
    
    void deleteCourseById(int id);

    InstructorDetail findInstructorDetailsById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCourseByInstructor(int id);

    Instructor findInstructorByJoinFetch(int id);

    void update(Instructor instructor);

    void update(Course course);

    void save(Course course);

    Course findCourseAndReviewByCourseId(int id);

    Course findCourseAndStudentsByCourseId(int id);

    Student findStudentAndCoursesByStudentId(int id);
}
