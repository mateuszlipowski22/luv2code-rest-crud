package com.luv2code.rest_application;

import com.luv2code.rest_application.dao.AppDAO;
import com.luv2code.rest_application.entity.Instructor;
import com.luv2code.rest_application.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner ->{
			createInstructor(appDAO);
		};
	}

	private void createInstructor(AppDAO appDAO) {
//		Instructor instructor = new Instructor("Adam", "Nowak","anowak@wp.pl");
//		InstructorDetail instructorDetail = new InstructorDetail("www.google.pl","coding");

		Instructor instructor = new Instructor("Marek", "Kowalski","mkowal@wp.pl");
		InstructorDetail instructorDetail = new InstructorDetail("www.yahoo.pl","sport");


		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving instructor: "+instructor);
		appDAO.save(instructor);
	}
}
