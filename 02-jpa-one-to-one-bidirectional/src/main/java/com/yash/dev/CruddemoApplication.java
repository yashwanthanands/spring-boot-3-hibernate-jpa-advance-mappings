package com.yash.dev;

import com.yash.dev.dao.AppDAO;
import com.yash.dev.entity.Instructor;
import com.yash.dev.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			deleteInstructorDetail(appDAO);
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor detail id : "+ theId);
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
		System.out.println(" Instructor Detail "+ tempInstructorDetail);
		System.out.println(" Instructor Profile "+ tempInstructorDetail.getInstructor());
		System.out.println("Delete Instructor Profile and Details");
		appDAO.deleteInstructorDetailsById(theId);
		System.out.println("Deleted Successfully");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor detail id : "+ theId);
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
		System.out.println(" Instructor Detail Profile "+ tempInstructorDetail);
		System.out.println(" Instructor Profile "+ tempInstructorDetail.getInstructor());

	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id : "+ theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println(" Instructor Profile "+ tempInstructor);
		System.out.println(" Instructor Details "+ tempInstructor.getInstructorDetail());
		System.out.println("Delete Instructor Profile and Details");
		appDAO.deleteInstructorById(theId);
		System.out.println("Deleted Successfully");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id : "+ theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println(" Instructor Profile "+ tempInstructor);
		System.out.println(" Instructor Details "+ tempInstructor.getInstructorDetail());

	}

	private void createInstructor(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("Chad","Darby","chad@gmail.com");

		InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.yash.com/chad",
						"Luv 2 Code!!!");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving the instructor "+tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Saved successfully");
	}

}
