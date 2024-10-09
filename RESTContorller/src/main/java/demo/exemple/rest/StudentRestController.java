package demo.exemple.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.exemple.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	//define endpoint for "/students" return a list of students
	@GetMapping("/students")
	public List<Student> getStudents(){
		List <Student> theStudents=new ArrayList<>();
		theStudents.add(new Student("Mohamed","Benmasnour"));
		theStudents.add(new Student("Mouna","wahada"));
		theStudents.add(new Student("damine","haj"));
		return theStudents;
	}
}
