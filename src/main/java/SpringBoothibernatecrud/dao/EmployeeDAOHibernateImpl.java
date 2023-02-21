package SpringBoothibernatecrud.dao;

import java.util.List;

import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import SpringBoothibernatecrud.entity.Employee;
import jakarta.persistence.EntityManager;



@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	
// ----------------------------------------Use Standard JPA implementation ---------------------------------------------------	
	private EntityManager  entityManager;
		
	@Autowired
	public EmployeeDAOHibernateImpl( EntityManager  entityManager) {
			
		this.entityManager=entityManager;
		
	}
		
	@Override
	public List<Employee> findAll() {
			
		jakarta.persistence.Query theQuery =  entityManager.createQuery("FROM Employee");
		
		List<Employee>  allEmployee = theQuery.getResultList();
		
		return allEmployee;	
			
	}
	
	@Override
	public Employee findById(int theId) {
		
		Employee employee = entityManager.find(Employee.class, theId);
		
		return employee;
	}
	
	@Override
	public void save(Employee theEmployee) {
		
		//entityManager.merge(theEmployee);
		
		// save or update the employee
	     Employee dbEmployee = entityManager.merge(theEmployee);
				
		// update with id from db ... so we can get generated id for save/insert
		 theEmployee.set_Id(dbEmployee.get_Id());
		
	}
	
	@Override
	public void deleteById(int theId) {
		
		jakarta.persistence.Query theQuery = entityManager.createQuery("DELETE  FROM Employee  WHERE id=: emploeeId");
		theQuery.setParameter("emploeeId", theId);
		
		theQuery.executeUpdate();
		
	}
	
	
	// ----------------------------------------Use Hibernate implementation ---------------------------------------------------
	

//	private EntityManager entityManager;
//	
//	@Autowired
//	public EmployeeDAOHibernateImpl (EntityManager theEntityManager) {
//		this.entityManager=theEntityManager;				
//	}
//	
//	@Override
//	@Transactional
//	public List<Employee> findAll() {
//		
//		Session currentSession = entityManager.unwrap(Session.class);
//		
//		org.hibernate.query.Query<Employee> theQuery = currentSession.createQuery("from Employee",Employee.class);
//		
//		List<Employee> employees = theQuery.getResultList();
//
//		return employees;
//	}
//
//	@Override
//	public Employee findById(int theId) {
//		Session currentSession = entityManager.unwrap(Session.class);
//		
//		Employee employee = currentSession.get(Employee.class, theId);
//		
//		return employee;
//	}
//
//	@Override
//	public void save(Employee theEmployee) {
//		Session currentSession = entityManager.unwrap(Session.class);
//		
//		currentSession.saveOrUpdate(theEmployee);
//		
//	}
//
//	@Override
//	public void deleteById(int theId) {
//		
//		Session currentSession = entityManager.unwrap(Session.class);
//		
//		Employee employee = currentSession.get(Employee.class, theId);
//		
//		currentSession.delete(employee);
//		
//	}

}
