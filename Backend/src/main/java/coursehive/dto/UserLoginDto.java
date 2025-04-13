package coursehive.dto;

import coursehive.entity.User;
import jakarta.validation.constraints.NotNull;

/**
 * DTO for User Requests and Respone
 */
public final class UserLoginDto {

    private UserLoginDto() {
        throw new UnsupportedOperationException("Utility Class allow no instantiation");
    }

    // Request DTO: To receive data from the client
    public record Request(
    @NotNull(message = "Username is required")
    String username,

    @NotNull(message = "Password is required")
    String password
) {}

public record Response(Long id, String username, String email, String fullName, String profilePicUrl, String joinedDate) {
    public static Response fromEntity(User user) {
        return new Response(
            user.getId(),
            user.getUsername(),
            user.getEmail(),
            user.getFullName(),
            user.getProfilePicUrl(),
            user.getCreatedAt().toString()
        );
    }
}

}
