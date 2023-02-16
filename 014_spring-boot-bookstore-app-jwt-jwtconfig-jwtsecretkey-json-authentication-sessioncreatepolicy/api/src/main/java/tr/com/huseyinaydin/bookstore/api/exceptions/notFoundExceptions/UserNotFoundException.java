package tr.com.huseyinaydin.bookstore.api.exceptions.notFoundExceptions;

/**
 * 
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot, React Bootcamp BTK Akademi Innova.
 * 
 */

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException(int id) {
        super(String.format("User with %s id could not found", id));
    }
}