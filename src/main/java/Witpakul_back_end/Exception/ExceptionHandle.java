package Witpakul_back_end.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice

public class ExceptionHandle {

    @ExceptionHandler(value = {ExceptionRequest.class})
    public ResponseEntity<Object>  handleException(ExceptionRequest e){
        HttpStatus notRequest = HttpStatus.NOT_FOUND;
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                e.getMessage(),
                notRequest,
                ZonedDateTime.now(ZoneId.of( "Asia/Bangkok" ))
        );
        return  new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
