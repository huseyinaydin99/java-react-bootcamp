package tr.com.huseyinaydin.bookstore.api.entities.dto;

import java.util.Set;

import lombok.Data;
import tr.com.huseyinaydin.bookstore.api.entities.Role;

/**
 * 
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot, React Bootcamp BTK Akademi Innova.
 * 
 */

@Data
public class UserDto {
    private int id;
    private String userName;
    private String firstName;
    private String lastName;
    private Set<Role> roles;
}
