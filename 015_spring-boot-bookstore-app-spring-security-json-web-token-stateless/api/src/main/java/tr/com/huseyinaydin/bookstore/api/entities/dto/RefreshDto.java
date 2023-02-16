package tr.com.huseyinaydin.bookstore.api.entities.dto;

import lombok.Data;

/**
 * 
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot, React Bootcamp BTK Akademi Innova.
 * 
 */

@Data
public class RefreshDto {
    private int userId;
    private String refreshToken;
}
