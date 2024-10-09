package demo.exemple.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.exemple.entity.Student;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	//define endpoint for "/students" return a list of students
	List <Student> theStudents;
	
	@PostConstruct
	public void loadData() {
		theStudents=new ArrayList<>();
		theStudents.add(new Student("Mohamed","Benmasnour"));
		theStudents.add(new Student("Mouna","wahada"));
		theStudents.add(new Student("damine","haj"));
		
	}
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		return theStudents;
	}
	//define endpoint or "/students/{studentId}" - return student at index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		//check the studentId again list size
		if((studentId>=theStudents.size())|| (studentId<0)) {
			throw new StudentNotFoundException("Student id not found - "+studentId);
		}
		return theStudents.get(studentId);
	}
}
