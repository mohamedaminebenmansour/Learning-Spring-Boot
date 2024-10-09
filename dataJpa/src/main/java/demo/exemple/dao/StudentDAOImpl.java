package demo.exemple.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import demo.exemple.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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

	@Override
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		//create query
		TypedQuery<Student> theQuery = entityManager.createQuery("From Student order by lastName",Student.class);
		//return query results
		return theQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName(String theLastName) {
		//create query
		TypedQuery<Student> theQuery = entityManager.createQuery("From Student where lastName=:theData",Student.class);

		//set query parameters
		theQuery.setParameter("theData", theLastName);
		//return query
		return theQuery.getResultList();
	}

	@Override
	@Transactional
	public void update(Student thesStudent) {
		entityManager.merge(thesStudent);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		//retrieve the student
		Student theStudent = entityManager.find(Student.class, id);
		//delete the student
		entityManager.remove(theStudent);
	}

}
