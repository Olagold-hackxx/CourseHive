package coursehive.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coursehive.dto.UserLoginDto;
import coursehive.dto.UserRegisterDto;
import coursehive.entity.User;
import coursehive.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterDto.Response> registerUser(@RequestBody UserRegisterDto.Request userRequest) {
        User createdUser = userService.register(userRequest);
        return ResponseEntity.ok(UserRegisterDto.Response.fromEntity(createdUser));
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginDto.Response> loginUser(@RequestBody UserLoginDto.Request userRequest) {
        User user = userService.login(userRequest);
        return ResponseEntity.ok(UserLoginDto.Response.fromEntity(user));
    }
}
