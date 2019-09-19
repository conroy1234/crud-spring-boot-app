package ord.app.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ord.app.crud.entity.Employee;
import ord.app.crud.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/")
	public String startUp() {
		return "redirect:/employees";
	}

	@GetMapping("/employees")
	public String findAll(Model model) {

		List<Employee> employees = employeeService.findAllByOrderByName();
		model.addAttribute("employees", employees);
		return "employees";
	}

	@GetMapping("/insert")
	public String insert(Model model, Employee employee) {

		model.addAttribute("employee", employee);
		return "insert";
	}

	@PostMapping("/insert")
	public String save(Model model, @ModelAttribute("employee") Employee employee) {
		employeeService.save(employee);
		return "redirect:employees";
	}

	@GetMapping("/updateEmployee")
	public String update(Model model, @RequestParam("employeeid") int id) {
		Optional<Employee> employee = employeeService.findById(id);
		model.addAttribute("employee", employee);
		return "insert";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("employeeid") int id) {
		employeeService.deleteById(id);
		return "redirect:employees";
	}
	
	
}
