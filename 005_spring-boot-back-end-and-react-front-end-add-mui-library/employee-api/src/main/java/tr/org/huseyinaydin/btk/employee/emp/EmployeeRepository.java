package tr.org.huseyinaydin.btk.employee.emp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 @author Huseyin_Aydin
 @since 1994
 @category Java, Spring Boot, React Bootcamp BTK Akademi Innova.
 * 
 */

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByFirstNameContainingIgnoreCase(String q);
}