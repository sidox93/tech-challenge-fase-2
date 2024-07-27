package br.com.fiap.parking_control.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;


@ControllerAdvice
public class ControllerExceptionHandler {

    private StandardError err = new StandardError();

    @ExceptionHandler(ControllerNotFundException.class)
    public ResponseEntity<StandardError> entityNotFound(ControllerNotFundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Entity not found");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(this.err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        ValidateError validateError = new ValidateError();

        validateError.setTimestamp(Instant.now());
        validateError.setStatus(status.value());
        validateError.setError("Erro de validação");
        validateError.setMessage(e.getMessage());
        validateError.setPath(request.getRequestURI());

        for (FieldError f : e.getBindingResult().getFieldErrors()) {
            validateError.addMenssagens(f.getField(), f.getDefaultMessage());
        }
        return ResponseEntity.status(status).body(validateError);
    }
}
