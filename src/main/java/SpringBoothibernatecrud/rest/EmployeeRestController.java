package SpringBoothibernatecrud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import SpringBoothibernatecrud.entity.Employee;
import SpringBoothibernatecrud.service.EmployeeService;
import SpringBoothibernatecrud.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(@Qualifier("employeeServiceImplSpData")EmployeeService employeeServiceImpl) {
		
		this.employeeService=employeeServiceImpl;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployeesById(@PathVariable int id) {
				
		Employee employee = employeeService.findById(id);
		
		if (employee==null) {
			throw new RuntimeException("Employee id not found "+id );
		}
		
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee thEmployee) {
		
		//thEmployee.set_Id(0);
		
		employeeService.save(thEmployee);
		
		return thEmployee;
		
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee thEmployee) {
		
		
		employeeService.save(thEmployee);
		
		return thEmployee;
		
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id) {
		
		Employee employee = employeeService.findById(id);
		
		if (employee==null) {
			throw new RuntimeException("Employee id not found "+id );
		}
		
		employeeService.deleteById(id);
		
		return "Deleted employee - "+ id;
		
	}
	

	
}
