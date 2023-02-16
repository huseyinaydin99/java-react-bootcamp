package tr.com.huseyinaydin.bookstore.api.services.Abstract;

import java.util.Optional;

import tr.com.huseyinaydin.bookstore.api.security.ApplicationUser;

/**
 * 
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot, React Bootcamp BTK Akademi Innova.
 * 
 */

public interface ApplicationUserDao {
    Optional<ApplicationUser> selectApplicationUserByUsername(String username);
}