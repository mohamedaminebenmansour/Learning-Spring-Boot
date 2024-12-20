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
	//find by last name
	List <Student> findByLastName(String theLastName);
	//update object
	void update(Student thesStudent);
	//delete a object
	void delete(Integer id);
	//delete all object and return number of objects 
	int deleteAll();
	
}
