package tr.com.huseyinaydin.bookstore.api.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import tr.com.huseyinaydin.bookstore.api.entities.Role;

/**
 * 
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot, React Bootcamp BTK Akademi Innova.
 * 
 */

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String string);
    Set<Role> findByIdIn(Set<Role> roles);   
}