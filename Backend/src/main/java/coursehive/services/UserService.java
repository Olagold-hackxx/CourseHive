package coursehive.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import coursehive.dto.UserRegisterDto;
import coursehive.entity.User;
import coursehive.exceptions.CustomException;
import coursehive.repository.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Register a new user
    public User register(UserRegisterDto.Request userRequestDto) {
        // Check if the user already exists
        if (userRepository.findByUsername(userRequestDto.username()).isPresent()) {
            throw new CustomException("Username already exists!");
        }

        if (userRepository.existsByEmail(userRequestDto.email())) {
            throw new IllegalArgumentException("Email is already taken");
        }

        // Map DTO to entity
        User user = new User();
        user.setUsername(userRequestDto.username());
        user.setEmail(userRequestDto.email());

        // Encrypt the password
        user.setPassword(passwordEncoder.encode(userRequestDto.password()));

        // Save the user in the database
        userRepository.save(user);

        return user;
    }

    // Login logic
    public User login(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isEmpty()) {
            throw new CustomException("User not found!");
        }

        // Check if password matches
        if (!passwordEncoder.matches(password, user.get().getPassword())) {
            throw new CustomException("Invalid credentials!");
        }

        // Successful login
        return user.get();
    }
}
