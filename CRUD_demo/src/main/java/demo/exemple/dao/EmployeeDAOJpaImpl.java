package demo.exemple.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.exemple.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	//define field for entityManager
	private EntityManager entityManager;
	
	//set up constructor injection
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		entityManager= theEntityManager;
	}
	@Override
	public List<Employee> findAll() {
		//create a quary 
		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee",Employee.class);
		//excute quary and get result list
		List<Employee> empolyees = theQuery.getResultList();
		//return the results
		
		
		return empolyees;
	}

}
