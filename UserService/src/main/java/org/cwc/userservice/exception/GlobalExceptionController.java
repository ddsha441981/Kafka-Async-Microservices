package org.cwc.userservice.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> userNotFoundException(UserNotFoundException ex, HttpServletRequest request) {
        log.info("User not found with this Id!");
        return  ResponseEntity.status(HttpStatus.NOT_FOUND.value())
                .body(ErrorResponse.builder()
                        .statusCode(HttpStatus.NOT_FOUND.value())
                        .timestamp(new Date())
                        .message("User not found with this Id!")
                        .description(ex.getMessage())
                        .path(request.getRequestURI())
                        .build());
    }

}
