package coursehive.controller;

import coursehive.dto.UserDto;
import coursehive.entity.User;
import coursehive.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto.Response> registerUser(@RequestBody UserDto.Request userRequest) {
        User createdUser = userService.register(userRequest);
        return ResponseEntity.ok(UserDto.Response.fromEntity(createdUser));
    }
}
