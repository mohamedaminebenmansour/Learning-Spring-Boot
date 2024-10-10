
package demo.exemple.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.exemple.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//that's it ...
}
