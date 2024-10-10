package demo.exemple.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	//add maping for GET /employees/{employeeId}
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee= employeeService.findById(employeeId);
		if(theEmployee==null) {
			throw new RuntimeException("Employee id not found - "+employeeId);
		}
		return theEmployee;
	}
	//add maping for Post /employees
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		//also just in case they pass an id in json ... set id to 0
		// this is to force a save of new item ... instead of update
		theEmployee.setId(0);
		Employee dbEmployee = employeeService.save(theEmployee);
		return dbEmployee;
	}
	
	//add maping for PUT /employees - update exictiing employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		Employee dbEmployee =employeeService.save(theEmployee);
		return dbEmployee;
	}
	
	//add maping for Delete /employees - delete employee
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee theEmployee= employeeService.findById(employeeId);
		if(theEmployee==null) {
			throw new RuntimeException("Employee id not found - "+employeeId);
		}
		employeeService.DeleteById(employeeId);
		return "Delete Employee with id - "+employeeId;
	}
}
