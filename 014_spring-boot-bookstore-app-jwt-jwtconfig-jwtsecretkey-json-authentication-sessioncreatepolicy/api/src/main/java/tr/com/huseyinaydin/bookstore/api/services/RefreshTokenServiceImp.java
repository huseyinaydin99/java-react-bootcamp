package tr.com.huseyinaydin.bookstore.api.services;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import tr.com.huseyinaydin.bookstore.api.entities.RefreshToken;
import tr.com.huseyinaydin.bookstore.api.entities.User;
import tr.com.huseyinaydin.bookstore.api.entities.models.ApiResponse;
import tr.com.huseyinaydin.bookstore.api.repositories.RefreshTokenRepository;
import tr.com.huseyinaydin.bookstore.api.services.Abstract.RefreshTokenService;

/**
 * 
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot, React Bootcamp BTK Akademi Innova.
 * 
 */

@Service
public class RefreshTokenServiceImp implements RefreshTokenService {

    @Value("${application.jwt.refresh.token.expires.in}")
    Long expireSeconds;

    private RefreshTokenRepository refreshTokenRepository;

    public RefreshTokenServiceImp(RefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }

    public ApiResponse<String> createRefreshToken(User user) {
        RefreshToken token = refreshTokenRepository.findByUserId(user.getId());
        if (token == null) {
            token = new RefreshToken();
            token.setUser(user);
        }
        token.setToken(UUID.randomUUID().toString());
        token.setExpiryDate(Date.from(Instant.now().plusSeconds(expireSeconds)));
        refreshTokenRepository.save(token);
        return ApiResponse.default_OK(token.getToken());
    }

    public ApiResponse<Boolean> isRefreshExpired(RefreshToken token) {
        Boolean isExpired = token.getExpiryDate().before(new Date());
        return ApiResponse.default_OK(isExpired);
    }

    public ApiResponse<RefreshToken> getByUser(int userId) {
        return ApiResponse.default_OK(refreshTokenRepository.findByUserId(userId));
    }
}
