package demo.exemple.dao;

import java.util.List;

import demo.exemple.entity.Employee;

public interface EmployeeDAO {

	List<Employee> findAll();
}
