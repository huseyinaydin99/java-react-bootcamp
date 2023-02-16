package tr.com.huseyinaydin.bookstore.api.services.Abstract;

import tr.com.huseyinaydin.bookstore.api.entities.RefreshToken;
import tr.com.huseyinaydin.bookstore.api.entities.User;
import tr.com.huseyinaydin.bookstore.api.entities.models.ApiResponse;

/**
 * 
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot, React Bootcamp BTK Akademi Innova.
 * 
 */

public interface RefreshTokenService {
    ApiResponse<String> createRefreshToken(User user);
    ApiResponse<Boolean> isRefreshExpired(RefreshToken token);
    ApiResponse<RefreshToken> getByUser(int userId);
}