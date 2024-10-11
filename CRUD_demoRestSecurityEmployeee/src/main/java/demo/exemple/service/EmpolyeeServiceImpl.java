package demo.exemple.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.exemple.entity.Employee;
import jakarta.transaction.Transactional;
import demo.exemple.dao.EmployeeDAO;
import demo.exemple.dao.EmployeeRepository;

@Service
public class EmpolyeeServiceImpl implements EmployeeService {

	private EmployeeRepository empolyeeRepository;
	
	@Autowired
	public EmpolyeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		empolyeeRepository = theEmployeeRepository;
	}
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return empolyeeRepository.findAll();
	}
	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		Optional<Employee> result= empolyeeRepository.findById(theId);
		Employee theEmployee=null;
		if(result.isPresent()) {
			theEmployee = result.get();
		}else {
			throw new RuntimeException("Did not find employee is -"+ theId);
		}
		return theEmployee;
	}
	@Transactional
	@Override
	public Employee save(Employee theEmployee) {
		// TODO Auto-generated method stub
		return empolyeeRepository.save(theEmployee);
	}
	@Transactional
	@Override
	public void DeleteById(int theId) {
		// TODO Auto-generated method stub
		empolyeeRepository.deleteById(theId);
		
	}

}
