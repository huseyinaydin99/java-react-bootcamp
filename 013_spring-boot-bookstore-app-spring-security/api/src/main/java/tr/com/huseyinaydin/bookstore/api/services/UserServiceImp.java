package tr.com.huseyinaydin.bookstore.api.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
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
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    
    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return Optional.empty();
    }   
}