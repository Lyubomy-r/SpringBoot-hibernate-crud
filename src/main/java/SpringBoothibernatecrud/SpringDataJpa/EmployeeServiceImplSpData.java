package SpringBoothibernatecrud.SpringDataJpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringBoothibernatecrud.entity.Employee;
import SpringBoothibernatecrud.service.EmployeeService;

@Service
public class EmployeeServiceImplSpData implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImplSpData (EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
		
	}
	
	@Override
	public List<Employee> findAll() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
			
		Optional <Employee> opEmployee= employeeRepository.findById(theId);
		
		Employee employee=null;
		if(opEmployee.isPresent()) {
		 employee =opEmployee.get();
		}else {
			throw new RuntimeException(" Did not find employee id "+theId);
		}
		
		return employee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		employeeRepository.save(theEmployee);

	}

	@Override
	public void deleteById(int theId) {
		
		employeeRepository.deleteById(theId);

	}

}
