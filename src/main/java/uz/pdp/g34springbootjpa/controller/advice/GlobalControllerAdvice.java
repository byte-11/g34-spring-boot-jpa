package uz.pdp.g34springbootjpa.controller.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.pdp.g34springbootjpa.dto.web.ErrorResponse;
import uz.pdp.g34springbootjpa.error.ErrorCode;
import uz.pdp.g34springbootjpa.exception.UserNotFoundException;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException e) {
        return ResponseEntity
                .status(ErrorCode.USER_NOT_FOUND.statusCode)
                .body(ErrorResponse.generate(ErrorCode.USER_NOT_FOUND, e.getMessage()));
    }
}
