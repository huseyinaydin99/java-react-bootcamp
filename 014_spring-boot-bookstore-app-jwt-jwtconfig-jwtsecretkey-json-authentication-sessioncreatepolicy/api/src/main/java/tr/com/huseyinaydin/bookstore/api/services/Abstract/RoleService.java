package tr.com.huseyinaydin.bookstore.api.services.Abstract;

import java.util.List;

import tr.com.huseyinaydin.bookstore.api.entities.Role;
import tr.com.huseyinaydin.bookstore.api.entities.models.ApiResponse;

/**
 * 
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot, React Bootcamp BTK Akademi Innova.
 * 
 */

public interface RoleService {
    ApiResponse<List<Role>> getAllRoles();
    ApiResponse<Role> postOneRole(Role role);
}