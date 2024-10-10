package demo.exemple.service;

import java.util.List;

import demo.exemple.entity.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	
	Employee findById(int theId);
	
	Employee save(Employee theEmployee);
	
	void DeleteById(int theId);

}
