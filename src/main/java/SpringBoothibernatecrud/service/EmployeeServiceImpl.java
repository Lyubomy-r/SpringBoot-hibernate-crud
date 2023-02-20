package SpringBoothibernatecrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import SpringBoothibernatecrud.dao.EmployeeDAO;
import SpringBoothibernatecrud.entity.Employee;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl( EmployeeDAO employeeDAO) {
		
		this.employeeDAO=employeeDAO;
	
	}
	
	@Override
	
	public List<Employee> findAll() {
		
		return employeeDAO.findAll();
	}

	@Override
	
	public Employee findById(int theId) {
		
		return employeeDAO.findById(theId);
	}

	@Override
	
	public void save(Employee theEmployee) {
		
		employeeDAO.save(theEmployee);
	}

	@Override
	
	public void deleteById(int theId) {
		
		employeeDAO.deleteById(theId);
	}

}
