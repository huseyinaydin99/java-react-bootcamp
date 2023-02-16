package tr.org.huseyinaydin.btk.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 @author Huseyin_Aydin
 @since 1994
 @category Java, Spring Boot, React Bootcamp BTK Akademi Innova.
 * 
 */

@SpringBootApplication
@RestController
@CrossOrigin
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@GetMapping
	public List<Employee> hello() {
		Employee emp1 = new Employee();
		emp1.setId(1);
		emp1.setFirstName("Hüseyin");
		emp1.setLastName("Aydın");
		emp1.setAge(19);

		Employee emp2 = new Employee(2, "Zafer", "İntepe", 34);

		List<Employee> list = new ArrayList<Employee>();
		list.add(emp1);
		list.add(emp2);
		list.add(new Employee(3, "Ali Kemal", "Apaydın", 35));
		list.add(new Employee(4, "Samet", "Ünlü", 23));

		return list;
	}
}