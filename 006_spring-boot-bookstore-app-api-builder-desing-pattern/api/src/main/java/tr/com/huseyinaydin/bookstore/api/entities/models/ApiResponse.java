package tr.com.huseyinaydin.bookstore.api.entities.models;

import java.sql.Timestamp;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * 
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot, React Bootcamp BTK Akademi Innova.
 * 
 */

@Data
@SuperBuilder
public class ApiResponse<T> {
    private HttpStatus httpStatus;
    private int statusCode;
    private String message;
    private T data;
    private Timestamp timestamp;
}
