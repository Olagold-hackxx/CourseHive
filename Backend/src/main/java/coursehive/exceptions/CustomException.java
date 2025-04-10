package coursehive.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User not found")
public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
