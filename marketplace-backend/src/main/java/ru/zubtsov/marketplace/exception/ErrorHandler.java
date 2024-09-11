package ru.zubtsov.marketplace.exception;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    public ResponseEntity<String> handleMethodNotValidException(MethodArgumentNotValidException e) {
        return new ResponseEntity<>("Invalid income data" + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleEntityAlreadyExistException(EntityAlreadyExist e) {
        return new ResponseEntity<>(e.getMessage(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFound e) {
        return new ResponseEntity<>(e.getMessage()
                ,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleBadCredentials(BadCredentialsException e) {
        return new ResponseEntity<>("Не корректный логин или пароль " + e.getMessage(),
                HttpStatus.UNAUTHORIZED);
    }

}
