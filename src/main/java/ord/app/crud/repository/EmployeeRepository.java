package ord.app.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ord.app.crud.entity.Employee;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	public List<Employee> findAllByOrderByName();

}
