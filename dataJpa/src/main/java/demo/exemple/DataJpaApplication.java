package demo.exemple;

import java.util.List;

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
			//System.out.println("-_-_-_-_-_-_-_Creating one student-_-_-_-_-_-");
			//createStudent(studentDAO);
			System.out.println("-_-_-_-_-_-_-_Creating multimples students-_-_-_-_-_-");
			createMultiplesStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudent(studentDAO);
			//queryForStudentByLastName(studentDAO);
			//updateStudent(studentDAO);
			//delteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		System.out.println("Deleting all students ...");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: "+numRowsDeleted);
				
	}

	private void delteStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		int studentId=3;
		System.out.println("Deleting student id: "+studentId);
		studentDAO.delete(studentId);
		System.out.println("Deleted");
		
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on the id(Primary key)
		int studnetId=1;
		System.out.println("Getting student with id: "+studnetId);
		Student myStudent = studentDAO.findById(studnetId);
		
		//change first name to
		System.out.println("Updating student...");
		myStudent.setFirstName("Damine");
		
		//update the std
		studentDAO.update(myStudent);
		
		//display the updated std
		System.out.println("updated student: "+myStudent);
		
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		//get a list of students
				List <Student> theStudents = studentDAO.findByLastName("wahada");	
				System.out.println("size of list :"+ theStudents.size());
				//display list of students
				for(Student tempStudent :theStudents) {
					System.out.println(tempStudent);
				}
		
	}

	private void queryForStudent(StudentDAO studentDAO) {
		//get a list of students
		List <Student> theStudents = studentDAO.findAll();
		
		//display list of students
		for(Student tempStudent :theStudents) {
			System.out.println(tempStudent);
		}
		
	}

	private void readStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("creating new student object ...");
		Student tempStudent = new Student("user", "Benmasnour","user@gmail.com");
				
		//save the student object
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);
				
		//display if of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student with id = "+theId);
			
		
		//retriver student based on the id: (Primary key)
		System.out.println("retriving student with id="+theId);
		Student myStudent= studentDAO.findById(theId);
		System.out.println("Fount the studnet:"+myStudent.toString());
		//display student
		
	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("creating new student object ...");
		Student tempStudent = new Student("user", "Benmasnour","user@gmail.com");
		
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
