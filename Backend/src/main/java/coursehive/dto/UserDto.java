package coursehive.dto;

import coursehive.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO for User Requests and Respone
 */
public final class UserDto {

    private UserDto() {
        throw new UnsupportedOperationException("Utility Class allow no instantiation");
    }

    // Request DTO: To receive data from the client
    public record Request(
            @NotNull(message = "Username is required")
            @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
            String username,
            @NotNull(message = "Password is required")
            @Size(min = 8, message = "Password must be at least 8 characters long")
            String password,
            @Email(message = "Invalid email format")
            @NotNull(message = "Email is required")
            String email) {

    }

    // Response DTO: return data to the client
    public record Response(Long id, String username, String email, String joinedDate) {

        // Map from entity to DTO
        public static Response fromEntity(User user) {
            return new Response(
                    user.getId(),
                    user.getUsername(),
                    user.getEmail(),
                    user.getCreatedAt().toString()
            );
        }

    }
}
