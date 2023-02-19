package SpringBoothibernatecrud.dao;

import java.util.List;

import SpringBoothibernatecrud.entity.Employee;

public interface EmployeeDAO {
	
	public List <Employee> findAll();

}
