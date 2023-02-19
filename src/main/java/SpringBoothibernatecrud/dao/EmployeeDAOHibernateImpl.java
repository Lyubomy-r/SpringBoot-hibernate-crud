package SpringBoothibernatecrud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import SpringBoothibernatecrud.entity.Employee;
import jakarta.persistence.EntityManager;


@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOHibernateImpl (EntityManager theEntityManager) {
		this.entityManager=theEntityManager;				
	}
	
	@Override
	public List<Employee> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Employee> theQuery = currentSession.createQuery("from Employee",Employee.class);
		
		List<Employee> employees = theQuery.getResultList();

		return employees;
	}

}
