package com.luv2code.rest_application;

import com.luv2code.rest_application.dao.AppDAO;
import com.luv2code.rest_application.entity.Course;
import com.luv2code.rest_application.entity.Instructor;
import com.luv2code.rest_application.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
//			  createInstructor(appDAO);
//			  findInstructor(appDAO);
//			  removeInstructor(appDAO);
//            findInstructorDetails(appDAO);
//			  removeInstructorDetail(appDAO);
//			  createInstructorWithCourses(appDAO);
//            findInstructorWithCourses(appDAO);
//            findCoursesForInstructor(appDAO);
//            findInstructorWithCoursesJoinFetch(appDAO);
//            updateInstructor(appDAO);
            updateCourse(appDAO);
        };
    }

    private void updateCourse(AppDAO appDAO) {
        int id=10;
        System.out.println("Finding course id : "+id);
        Course course = appDAO.findCourseById(id);

        System.out.println("Updating course id : " + id);
        course.setTitle("Nowy tytul");

        appDAO.update(course);

        System.out.println("Done");
    }

    private void updateInstructor(AppDAO appDAO) {
        int id=1;
        System.out.println("Finding instructor id : "+id);
        Instructor instructor = appDAO.findInstructorById(id);

        System.out.println("Updating instructor id : " + id);
        instructor.setLastName("Zmiana");

        appDAO.update(instructor);

        System.out.println("Done");
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
        int id=1;
        System.out.println("Finding instructor id : "+id);
        Instructor instructor = appDAO.findInstructorByJoinFetch(id);
        System.out.println("instructor : "+instructor);
        System.out.println("the associated courses: "+instructor.getCourses());
        System.out.println("Done");
    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int id=1;
        System.out.println("Finding instructor id : "+id);
        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println("instructor : "+instructor);
        System.out.println("Finding courses for instructor id: "+id);
        List<Course> courses = appDAO.findCourseByInstructor(id);
        instructor.setCourses(courses);
        System.out.println("the associated courses: "+instructor.getCourses());
        System.out.println("Done");
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        int id=1;
        System.out.println("Finding instructor id : "+id);
        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println("instructor : "+instructor);
        System.out.println("The courses : " + instructor.getCourses());

        System.out.println("Done ");
    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        Instructor instructor = new Instructor("Marek", "Baranek", "baran@wp.pl");
        InstructorDetail instructorDetail = new InstructorDetail("www.google.pl", "sport");

        instructor.setInstructorDetail(instructorDetail);

        Course course1 = new Course("Air guitar");
        Course course2 = new Course("Paintball");

        instructor.add(course1);
        instructor.add(course2);

        System.out.println("Saving instructor : " + instructor);
        System.out.println("The courses : " + instructor.getCourses());
        appDAO.save(instructor);
    }

    private void removeInstructorDetail(AppDAO appDAO) {
        int id = 2;
        System.out.println("Removing instructor detail of : " + id);
        appDAO.deleteInstructorDetailById(id);
        System.out.println("Done");
    }

    private void findInstructorDetails(AppDAO appDAO) {
		int id = 2;
		System.out.println("Finding instructor details of : " + id);
		InstructorDetail instructorDetail = appDAO.findInstructorDetailsById(id);
		System.out.println("instructorDetail : " + instructorDetail);
		System.out.println("Associated instructor : " + instructorDetail.getInstructor());
        System.out.println("Done");
	}

	private void removeInstructor(AppDAO appDAO) {
        int id = 1;
        System.out.println("Removing instructor of : " + id);
        appDAO.deleteInstructorById(id);
        System.out.println("Done");
    }

    private void findInstructor(AppDAO appDAO) {
        int id = 2;
        System.out.println("Finding instructor of : " + id);
        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println("instructor : " + instructor);
        System.out.println("Associated instructor details : " + instructor.getInstructorDetail());
    }

    private void createInstructor(AppDAO appDAO) {
//		Instructor instructor = new Instructor("Adam", "Nowak","anowak@wp.pl");
//		InstructorDetail instructorDetail = new InstructorDetail("www.google.pl","coding");

        Instructor instructor = new Instructor("Marek", "Kowalski", "mkowal@wp.pl");
        InstructorDetail instructorDetail = new InstructorDetail("www.yahoo.pl", "sport");

        instructor.setInstructorDetail(instructorDetail);

        System.out.println("Saving instructor: " + instructor);
        appDAO.save(instructor);
    }
}
