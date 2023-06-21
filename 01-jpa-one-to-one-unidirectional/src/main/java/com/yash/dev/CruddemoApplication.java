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
			createInstructor(appDAO);
		};
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
