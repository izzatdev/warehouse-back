package com.example.warehouse.configs;

import com.example.warehouse.exceptions.CustomException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.webjars.NotFoundException;

import java.util.List;

@Log4j2
@RestControllerAdvice
public class RestExceptionHandler {
    private record ExceptionResponse(List<String> errors) {
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse illegalArgument(final IllegalArgumentException ex) {
        return new ExceptionResponse(List.of(ex.getMessage()));
    }

    @ExceptionHandler(value = NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse notFound(final NotFoundException ex) {
        return new ExceptionResponse(List.of(ex.getMessage()));
    }

    @ExceptionHandler(value = CustomException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse notFound(final CustomException ex) {
        return new ExceptionResponse(List.of(ex.getMessage()));
    }
}
