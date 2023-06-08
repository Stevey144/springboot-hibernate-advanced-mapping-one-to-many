package com.luv2code.HibernateMappingDemo;

import com.luv2code.HibernateMappingDemo.Dao.AppDao;
import com.luv2code.HibernateMappingDemo.entity.Course;
import com.luv2code.HibernateMappingDemo.entity.Instructor;
import com.luv2code.HibernateMappingDemo.entity.InstructorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateMappingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateMappingDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){
		return runner ->{
			//createInstructor(appDao);
			//findInstructor(appDao);
			//deleteInstructor(appDao);
			//findInstructorDetails(appDao);
			//deleteInstructorDetails(appDao);
			//createInstructorWithCourse(appDao);
			findInstructorWithCourses(appDao);
		};
	}

	private void findInstructorWithCourses(AppDao appDao) {
		int theId = 1;
		System.out.println("find instructor with the Id of " + theId);
		Instructor tempInstructor  = appDao.findInstructorById(theId);
		System.out.println(tempInstructor);
		System.out.println("associated courses includes : "+ tempInstructor.getCourses());

	}

	private void createInstructorWithCourse(AppDao appDao) {
		//create the Instructor
		Instructor theInstructor = new Instructor("mica","sussan","sussan@gmail.com");
		// create the instructor details
		InstructorDetails tempInstructorDetails = new InstructorDetails("gamer@gmail.com","gamer");
		//associates the object together
		theInstructor.setInstructorDetails(tempInstructorDetails);
		//save the instructor
		//Note !! this will also save the instructor details because of the
		//cascadeType.All
		Course tempCourseOne = new Course("Air Guitar");

		Course tempCourse2= new Course("Spring boot zero to mastery");
		theInstructor.add(tempCourseOne);
		theInstructor.add(tempCourse2);

		System.out.println("Saving the Instructor " + theInstructor);
		System.out.println("The Courses: " + theInstructor.getCourses());
		appDao.save(theInstructor);

		System.out.println("----------Operation completed----------");
	}

	private void deleteInstructorDetails(AppDao appDao) {
		int InstructorDetailsId = 7;
		System.out.print("deleting Instructor details with an ID of = " + InstructorDetailsId);
		appDao.deleteInstructorDetailsById(InstructorDetailsId);
		System.out.print("DELETED SUCCESSFULLY!!");

	}

	private void findInstructorDetails(AppDao appDao) {
		int InstructorDetailsId = 4;
		InstructorDetails tempInstructorDetails = appDao.findInstructorDetailById(InstructorDetailsId);

		System.out.println("Instructor details are = "+ tempInstructorDetails);

		System.out.println("Associated Instructor includes : " + tempInstructorDetails.getInstructor());

		System.out.print("done");


	}

	private void deleteInstructor(AppDao appDao) {
		int InstructorId = 2;
		System.out.println("deleting instructor details with id of = " + InstructorId);
		appDao.deleteInstructor(InstructorId);
		System.out.println("deleted successfully");


	}

	private void findInstructor(AppDao appDao) {
		int theId = 1;
		System.out.println("Finding instructor id : " + theId);
		Instructor tempInstructor = appDao.findInstructorById(theId);
		System.out.println("Instructor details includes : " + tempInstructor );
		System.out.println("the associated instructorDetail only : " + tempInstructor.getInstructorDetails());
	}

	private void createInstructor(AppDao appDao) {
		//create the Instructor
		Instructor theInstructor = new Instructor("stephen","ogechi","code.com");
		// create the instructor details
		InstructorDetails tempInstructorDetails = new InstructorDetails("love2code.com","eating");
		//associates the object together
		theInstructor.setInstructorDetails(tempInstructorDetails);
		//save the instructor
		//Note !! this will also save the instructor details because of the
		//cascadeType.All
		System.out.println("Instructor saved Successfully, details = :" + theInstructor);
		appDao.save(theInstructor);
        System.out.println("----------Operation completed----------");

	}

}
