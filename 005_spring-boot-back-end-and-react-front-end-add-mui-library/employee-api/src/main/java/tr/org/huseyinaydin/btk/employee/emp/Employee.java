package tr.org.huseyinaydin.btk.employee.emp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 @author Huseyin_Aydin
 @since 1994
 @category Java, Spring Boot, React Bootcamp BTK Akademi Innova.
 * 
 */

@Data
@NoArgsConstructor // default constructor
@AllArgsConstructor // constructor with all fields
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;
}
