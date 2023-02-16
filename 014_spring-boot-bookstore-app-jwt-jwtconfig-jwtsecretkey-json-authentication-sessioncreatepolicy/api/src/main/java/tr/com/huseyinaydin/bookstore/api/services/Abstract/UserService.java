package tr.com.huseyinaydin.bookstore.api.services.Abstract;

import java.util.List;

import tr.com.huseyinaydin.bookstore.api.entities.User;
import tr.com.huseyinaydin.bookstore.api.entities.models.ApiResponse;

/**
 * 
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot, React Bootcamp BTK Akademi Innova.
 * 
 */

public interface UserService extends ApplicationUserDao {
    ApiResponse<List<User>> getAllUsers();
    ApiResponse<User> getOneUser(int id);
    ApiResponse<User> postOneUser(User user);
    ApiResponse<User> putOneUser(int id, User user);
    User getOneUserByUserName(String username);
    void deleteOneUser(int id);
    User saveOneUser(User user);
}