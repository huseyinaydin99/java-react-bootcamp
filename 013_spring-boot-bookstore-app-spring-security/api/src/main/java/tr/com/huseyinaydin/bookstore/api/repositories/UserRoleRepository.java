package tr.com.huseyinaydin.bookstore.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tr.com.huseyinaydin.bookstore.api.entities.UserRole;

/**
 * 
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot, React Bootcamp BTK Akademi Innova.
 * 
 */

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    
}
