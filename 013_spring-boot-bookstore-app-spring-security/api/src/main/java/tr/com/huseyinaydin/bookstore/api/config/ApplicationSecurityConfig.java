package tr.com.huseyinaydin.bookstore.api.config;

import static tr.com.huseyinaydin.bookstore.api.security.ApplicationUserPermission.*;
import static tr.com.huseyinaydin.bookstore.api.security.ApplicationUserRole.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import lombok.RequiredArgsConstructor;
import tr.com.huseyinaydin.bookstore.api.services.ApplicationUserService;

/**
 * 
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot, React Bootcamp BTK Akademi Innova.
 * 
 */

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig
                extends WebSecurityConfigurerAdapter {

        private final PasswordEncoder passwordEncoder;
        private final ApplicationUserService applicationUserService;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
                http
                                .csrf().disable()
                                .authorizeRequests()
                                .antMatchers("/api/v1/**").permitAll()
                                .anyRequest()
                                .authenticated()
                                .and()
                                .httpBasic();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
                auth.authenticationProvider(daoAuthenticationProvider());
        }

        private AuthenticationProvider daoAuthenticationProvider() {
                DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
                provider.setPasswordEncoder(passwordEncoder);
                provider.setUserDetailsService(applicationUserService);
                return provider;
        }
}