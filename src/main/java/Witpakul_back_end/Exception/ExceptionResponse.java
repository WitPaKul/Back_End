package Witpakul_back_end.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
@AllArgsConstructor
@Getter

public class ExceptionResponse {

    private final String message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;

}
