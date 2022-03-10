package com.devsuperior.dslearnbds.resources.exceptions;

import com.devsuperior.dslearnbds.services.exceptions.DataBaseException;
import com.devsuperior.dslearnbds.services.exceptions.ForbiddenException;
import com.devsuperior.dslearnbds.services.exceptions.ResourceNotFoundException;
import com.devsuperior.dslearnbds.services.exceptions.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice //Escuta as exceptions lançadas nos Controllers
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class) //Capturando exception específica
    public ResponseEntity<StandarError> notFoundExceptionResponseEntity(ResourceNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandarError error = new StandarError();
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Resource not found");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(DataBaseException.class) //Capturando exception específica
    public ResponseEntity<StandarError> database(DataBaseException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandarError error = new StandarError();
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Resource not found");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class) //Capturando exception específica create or update the user
    public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY; //Significa que a entidade não pôde ser processada 422
        ValidationError error = new ValidationError();
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Validation Exception");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());

        for(FieldError f : e.getBindingResult().getFieldErrors()){
            error.addErros(f.getField(), f.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(ForbiddenException.class) //Capturando exception específica
    public ResponseEntity<OAuthCustomError> forbidden(ForbiddenException e, HttpServletRequest request){
        OAuthCustomError error = new OAuthCustomError("Forbidden",e.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error); // Status 403 Acesso proibido (Sem token)
    }

    @ExceptionHandler(UnauthorizedException.class) //Capturando exception específica
    public ResponseEntity<OAuthCustomError> unauthorized(UnauthorizedException e, HttpServletRequest request){
        OAuthCustomError error = new OAuthCustomError("Unauthorized",e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error); // Status 401 Acesso negado (O token é válido, porém, não tem permissão para o recurso )
    }
}
