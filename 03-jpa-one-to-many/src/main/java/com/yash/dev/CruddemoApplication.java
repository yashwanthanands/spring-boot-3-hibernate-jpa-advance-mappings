package com.yash.dev;

import com.yash.dev.dao.AppDAO;
import com.yash.dev.entity.Course;
import com.yash.dev.entity.Instructor;
import com.yash.dev.entity.InstructorDetail;
import java.util.List;
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
			deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			//deleteInstructorDetail(appDAO);
			//createInstructorWithCourses(appDAO);
			//findInstructorWithCourses(appDAO);
			//findCoursesForInstructor(appDAO);
			//findInstructorWithCourseJoinFetch(appDAO);
			//updateInstructor(appDAO);
			//updateCourse(appDAO);
		};
	}

	private void updateCourse(AppDAO appDAO) {
		int theId=10;
		//find course
		System.out.println("Finding course id "+theId);
		Course tempCourse = appDAO.findCourseById(theId);

		//update the instructor
		System.out.println("Updating course id : "+theId);
		tempCourse.setTitle("Java Programming");

		appDAO.update(tempCourse);
		System.out.println("Updated the course successfully");
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId=1;
		//find instructor
		System.out.println("Finding instructor id "+theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		//update the instructor
		System.out.println("Updating instructor id : "+theId);
		tempInstructor.setLastName("Tester");

		appDAO.update(tempInstructor);
		System.out.println("Updated successfully");
	}

	private void findInstructorWithCourseJoinFetch(AppDAO appDAO) {
		int theId=1;

		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("Instructor with associated courses"+tempInstructor);
		System.out.println("Associated courses"+tempInstructor.getCourses());
		System.out.println("Done");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		int theId=1;
		System.out.println("Finding instructor id : "+theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor "+tempInstructor);

		System.out.println("Finding courses for instructor id: "+theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);
		tempInstructor.setCourses(courses);
		System.out.println(" the associated courses: "+tempInstructor.getCourses());
		System.out.println("Done");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id "+theId);
		Instructor tempInstructor= appDAO.findInstructorById(theId);
		System.out.println("tempInstructor "+tempInstructor);
		System.out.println("tempInstructor associated courses"+tempInstructor.getCourses());
		System.out.println("Done");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("Chad","Darby","chad@gmail.com");
		InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.yash.com/chad",
				"Luv 2 Code!!!");
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course tempCourse1=new Course("Java");
		Course tempCourse2=new Course("Spring");
		Course tempCourse3=new Course("Microservices");

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		tempInstructor.add(tempCourse3);

		System.out.println("Saving the instructor with details and courses "+tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Saved successfully");
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
