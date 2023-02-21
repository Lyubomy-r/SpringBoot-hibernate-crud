package SpringBoothibernatecrud.SpringDataJpa;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringBoothibernatecrud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
