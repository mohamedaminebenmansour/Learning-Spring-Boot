package demo.exemple;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import demo.exemple.dao.StudentDAO;
import demo.exemple.entity.Student;

@SpringBootApplication
public class DataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataJpaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner ->{
			//creating a object
			System.out.println("-_-_-_-_-_-_-_Creating one student-_-_-_-_-_-");
			createStudent(studentDAO);
			System.out.println("-_-_-_-_-_-_-_Creating multimples students-_-_-_-_-_-");
			createMultiplesStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("creating new student object ...");
		Student tempStudent = new Student("Mohamed Amine", "Benmasnour","mohamedpoly9@gmail.com");
		
		//save the student object
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);
		
		//display if of the saved student
		System.out.println("Saved student with id = "+tempStudent.getId());
	}
	
	private void createMultiplesStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("creating new students object ...");
		Student tempStudent1 = new Student("Mohamed Amine", "Benmasnour","mohamedpoly9@gmail.com");
		Student tempStudent2 = new Student("Mouna", "wahada","wahadamouna@gmail.com");
		Student tempStudent3 = new Student("Bassem", "mdallel","mdallelBassem@gmail.com");

		//save the student object
		System.out.println("Saving the students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		
		//display if of the saved student
		System.out.println(tempStudent1.toString());
		System.out.println(tempStudent2.toString());
		System.out.println(tempStudent3.toString());
	}

}
