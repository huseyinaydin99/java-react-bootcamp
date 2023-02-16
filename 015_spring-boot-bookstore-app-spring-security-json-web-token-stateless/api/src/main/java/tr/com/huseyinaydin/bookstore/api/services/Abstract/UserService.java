package tr.com.huseyinaydin.bookstore.api.services.Abstract;

import java.util.List;

import tr.com.huseyinaydin.bookstore.api.entities.User;
import tr.com.huseyinaydin.bookstore.api.entities.dto.UserDto;
import tr.com.huseyinaydin.bookstore.api.entities.models.ApiResponse;

/**
 * 
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot, React Bootcamp BTK Akademi Innova.
 * 
 */

public interface UserService extends ApplicationUserDao {
    ApiResponse<List<UserDto>> getAllUsers();
    ApiResponse<UserDto> getOneUser(int id);
    ApiResponse<UserDto> postOneUser(User user);
    ApiResponse<UserDto> putOneUser(int id, User user);
    User getOneUserByUserName(String username);
    void deleteOneUser(int id);
    User saveOneUser(User user);
}