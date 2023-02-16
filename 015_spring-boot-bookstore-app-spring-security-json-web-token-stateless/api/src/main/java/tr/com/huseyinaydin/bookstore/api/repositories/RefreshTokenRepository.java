package tr.com.huseyinaydin.bookstore.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tr.com.huseyinaydin.bookstore.api.entities.RefreshToken;

/**
 * 
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot, React Bootcamp BTK Akademi Innova.
 * 
 */

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Integer> {
    RefreshToken findByUserId(int userId);
}