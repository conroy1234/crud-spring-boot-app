package ord.app.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ord.app.crud.entity.Employee;
import ord.app.crud.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> findAllByOrderByName() {
		return employeeRepository.findAllByOrderByName();

	}

	public void save(Employee employee) {
		employeeRepository.save(employee);

	}

	public Optional<Employee> findById(long id) {

		Optional<Employee> employee = employeeRepository.findById(id);
		return employee;
	}

	public void deleteById(long id) {

		employeeRepository.deleteById(id);
	}
}
