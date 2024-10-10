package demo.exemple.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.exemple.dao.EmployeeDAO;
import demo.exemple.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmpolyeeRestController {

	private EmployeeDAO employeeDAO;
	//quick and dirty: inject employee dao
	public EmpolyeeRestController(EmployeeDAO theEmployeeDAO) {
		employeeDAO=theEmployeeDAO;
	}
	//expose "/employees" and return a list of employee
	@GetMapping("/employees")
	public List<Employee> fndAll(){
		return employeeDAO.findAll();
	}
}
