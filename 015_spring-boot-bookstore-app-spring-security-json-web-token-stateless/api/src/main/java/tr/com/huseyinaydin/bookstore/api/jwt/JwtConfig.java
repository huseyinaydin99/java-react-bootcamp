package tr.com.huseyinaydin.bookstore.api.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import lombok.Data;

/**
 * 
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot, React Bootcamp BTK Akademi Innova.
 * 
 */

@Configuration
@ConfigurationProperties(prefix = "application.jwt")
@Data
public class JwtConfig {

    private String secretKey;
    private String tokenPrefix;

    @Value("${application.jwt.expires.in}")
    private Long expiresIn;

    public String getAuthorizationHeader() {
        return HttpHeaders.AUTHORIZATION;
    }
}