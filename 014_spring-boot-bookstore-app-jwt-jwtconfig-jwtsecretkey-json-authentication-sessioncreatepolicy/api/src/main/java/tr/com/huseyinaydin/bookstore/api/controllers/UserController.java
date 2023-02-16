package tr.com.huseyinaydin.bookstore.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tr.com.huseyinaydin.bookstore.api.entities.User;
import tr.com.huseyinaydin.bookstore.api.repositories.UserRepository;
import tr.com.huseyinaydin.bookstore.api.services.Abstract.ApplicationUserDao;
import tr.com.huseyinaydin.bookstore.api.services.Abstract.UserService;

/**
 * 
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot, React Bootcamp BTK Akademi Innova.
 * 
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService; // UserServiceImp

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        var response = userService.getAllUsers();
        return ResponseEntity
                .status(response.getHttpStatus())
                .body(response);
    }

    @PostMapping
    public ResponseEntity<?> postOneUser(@RequestBody User user) {
        var response = userService.postOneUser(user);
        return ResponseEntity
                .status(response.getHttpStatus())
                .body(response);
    }
}