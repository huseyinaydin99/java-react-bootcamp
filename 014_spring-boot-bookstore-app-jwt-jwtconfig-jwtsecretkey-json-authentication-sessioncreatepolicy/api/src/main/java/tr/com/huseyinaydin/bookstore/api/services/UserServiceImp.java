package tr.com.huseyinaydin.bookstore.api.services;

import static tr.com.huseyinaydin.bookstore.api.security.ApplicationUserRole.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tr.com.huseyinaydin.bookstore.api.entities.Role;
import tr.com.huseyinaydin.bookstore.api.entities.User;
import tr.com.huseyinaydin.bookstore.api.entities.models.ApiResponse;
import tr.com.huseyinaydin.bookstore.api.exceptions.notFoundExceptions.UserNotFoundException;
import tr.com.huseyinaydin.bookstore.api.repositories.RoleRepository;
import tr.com.huseyinaydin.bookstore.api.repositories.UserRepository;
import tr.com.huseyinaydin.bookstore.api.security.ApplicationUser;
import tr.com.huseyinaydin.bookstore.api.services.Abstract.UserService;

/**
 * 
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot, React Bootcamp BTK Akademi Innova.
 * 
 */

@Service
@RequiredArgsConstructor
@Repository("mysql")
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {

        /// User
        User user = userRepository.findByUserName(username);

        // Role
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<Role> roles = new HashSet<>(); // ADMIN / EDITOR / USER
        roles = user.getRoles();
        // Bu uygulamada biz sadece 1 kayıt tutuyoruz. Ancak altyapı birden fazla role
        // tanımı yapmaya uygun!
        for (Role role : roles) {
            switch (role.getName()) { // role.getName()
                case "USER": // USER
                    grantedAuthorities.addAll(USER.getGrantedAuthorities());
                    break;
                case "EDITOR": // EDITOR  /// "EDITOR"
                    grantedAuthorities.addAll(EDITOR.getGrantedAuthorities());
                    break;
                case "ADMIN": // ADMIN
                    grantedAuthorities.addAll(ADMIN.getGrantedAuthorities());
                    break;
                default:
                    break;
            }
        }

        // ADMIN
        Optional<ApplicationUser> applicationUser = Optional
                .ofNullable(new ApplicationUser(username,
                        user.getPassword(),
                        grantedAuthorities, // Role tablosuna role al - enum ile birleştir
                        true,
                        true,
                        true,
                        true));

        return applicationUser;
    }

    @Override
    public ApiResponse<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ApiResponse.default_OK(users);
    }

    @Override
    public ApiResponse<User> getOneUser(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        return ApiResponse.default_OK(user);
    }

    @Override
    public ApiResponse<User> postOneUser(User user) {
        Set<Role> roles = new HashSet<>();
        Role role = roleRepository.findByName("USER");
        if (role == null) {
            throw new RuntimeException("USER role is not defined.");
        }
        roles.add(role);
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return ApiResponse.default_CREATED(user);
    }

    @Override
    public ApiResponse<User> putOneUser(int id, User user) {

        User updatedUser = getOneUser(id).getData();
        // dto gelecek...
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());

        // Roles
        Set<Role> roles = roleRepository.findByIdIn(user.getRoles());
        updatedUser.setRoles(roles);

        userRepository.save(updatedUser);

        return ApiResponse.default_ACCEPTED(updatedUser);
    }

    @Override
    public User getOneUserByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public void deleteOneUser(int id) {
        getOneUser(id);
        userRepository.deleteById(id);
    }

    @Override
    public User saveOneUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role role = roleRepository.findByName("USER");
        roles.add(role);
        user.setRoles(roles);

        return userRepository.save(user);
    }
}