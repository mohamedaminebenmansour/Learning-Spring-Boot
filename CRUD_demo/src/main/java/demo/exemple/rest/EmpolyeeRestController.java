package demo.exemple.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import demo.exemple.entity.Employee;
import demo.exemple.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmpolyeeRestController {

	private EmployeeService employeeService;
	//quick and dirty: inject employee dao
	public EmpolyeeRestController(EmployeeService theEmployeeService) {
		employeeService=theEmployeeService;
	}
	//expose "/employees" and return a list of employee
	@GetMapping("/employees")
	public List<Employee> fndAll(){
		return employeeService.findAll();
	}
}
