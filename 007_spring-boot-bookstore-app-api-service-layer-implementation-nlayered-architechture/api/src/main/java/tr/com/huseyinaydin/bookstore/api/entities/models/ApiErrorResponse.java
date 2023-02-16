package tr.com.huseyinaydin.bookstore.api.entities.models;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//بسم الله الرحمن الرحيم

/**  
 * Bootcamp BTK Akademi Innova
 * 
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot, React Bootcamp BTK Akademi Innova.
 * 
 */

@Data
@AllArgsConstructor
@ToString
public class ApiErrorResponse<T> extends ApiResponse<T> {
    private String path;
    private List<String> errors;

    public ApiErrorResponse() {
        super();
        this.setHttpStatus(HttpStatus.BAD_REQUEST);
        this.setStatusCode(HttpStatus.BAD_REQUEST.value());
        this.setMessage(ResponseMessage.fail);
    }
}