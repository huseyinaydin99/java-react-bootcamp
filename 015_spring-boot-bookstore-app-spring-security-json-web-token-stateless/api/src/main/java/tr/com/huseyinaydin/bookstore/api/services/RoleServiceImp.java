package tr.com.huseyinaydin.bookstore.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tr.com.huseyinaydin.bookstore.api.entities.Role;
import tr.com.huseyinaydin.bookstore.api.entities.models.ApiResponse;
import tr.com.huseyinaydin.bookstore.api.repositories.RoleRepository;
import tr.com.huseyinaydin.bookstore.api.services.Abstract.RoleService;

/**
 * 
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot, React Bootcamp BTK Akademi Innova.
 * 
 */

@Service
public class RoleServiceImp implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public ApiResponse<List<Role>> getAllRoles() {
        var roles = roleRepository.findAll();
        return ApiResponse.default_OK(roles);
    }

    @Override
    public ApiResponse<Role> postOneRole(Role role) {
        roleRepository.save(role);
        return ApiResponse.default_CREATED(role);
    }
}