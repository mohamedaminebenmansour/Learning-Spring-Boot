package demo.exemple.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.exemple.entity.Employee;
import demo.exemple.dao.EmployeeDAO;

@Service
public class EmpolyeeServiceImpl implements EmployeeService {

	private EmployeeDAO empolyeeDAO;
	
	@Autowired
	public EmpolyeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		empolyeeDAO = theEmployeeDAO;
	}
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return empolyeeDAO.findAll();
	}

}
