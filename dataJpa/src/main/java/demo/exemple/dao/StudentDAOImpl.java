package demo.exemple.dao;

import org.springframework.stereotype.Repository;

import demo.exemple.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


@Repository
public class StudentDAOImpl implements StudentDAO {

	//define field for entity manage
	
	private EntityManager entityManager;
	//inject entity manager using constractor injection
	
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager= entityManager;
	}
	
	//creating a object
	//implement save method
	
	@Override
	@Transactional
	public void save(Student theStudent) {
		// TODO Auto-generated method stub
		entityManager.persist(theStudent);
	}

}
