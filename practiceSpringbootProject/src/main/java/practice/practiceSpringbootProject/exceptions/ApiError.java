package practice.practiceSpringbootProject.exceptions;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ApiError {
    HttpStatus httpStatus;
    String message;
}
