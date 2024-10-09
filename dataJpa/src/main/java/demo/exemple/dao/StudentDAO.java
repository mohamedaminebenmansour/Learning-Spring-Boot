package demo.exemple.dao;

import java.util.List;

import demo.exemple.entity.Student;

public interface StudentDAO {

	//creating a object
	void save(Student theStudent);
	//Read a object
	Student findById(Integer id);
	//read a list of objects
	List <Student> findAll();
	
}
