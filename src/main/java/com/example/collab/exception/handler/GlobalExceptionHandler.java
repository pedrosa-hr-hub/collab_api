package com.example.collab.exception.handler;

import com.example.collab.exception.business.*;
import com.example.collab.exception.domain.*;
import com.example.collab.exception.resource.*;
import com.example.collab.exception.dto.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // RECURSO NÃO ENCONTRADO (HTTP 404)
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(NotFoundException ex, WebRequest req) {

        var body = ErrorResponse.of(HttpStatus.NOT_FOUND.value(), "Not Found", ex.getMessage(), path(req));

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);

    }

    // REQUISIÇÃO INVÁLIDA (HTTP 400)
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException ex, WebRequest req) {

        var body = ErrorResponse.of(HttpStatus.BAD_REQUEST.value(), "Bad Request", ex.getMessage(), path(req));

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);

    }

    // VALOR DUPLICADO (HTTP 409)
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorResponse> handleConflict(ConflictException ex, WebRequest req) {

        var body = ErrorResponse.of(HttpStatus.CONFLICT.value(), "Conflict", ex.getMessage(), path(req));

        return new ResponseEntity<>(body, HttpStatus.CONFLICT);

    }

    // DADOS INSERIDOS NÃO CONDIZEM COM O VALOR ESPERADO (HTTP 422)
    @ExceptionHandler({ UnprocessableEntityException.class, InvalidDocumentException.class })
    public ResponseEntity<ErrorResponse> handleUnprocessable(RuntimeException ex, WebRequest req) {

        var body = ErrorResponse.of(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Unprocessable Entity", ex.getMessage(),
                path(req));

        return new ResponseEntity<>(body, HttpStatus.UNPROCESSABLE_ENTITY);

    }

    // ANOTAÇÃO NÃO ATENDIDA (HTTP 400)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex, WebRequest req) {

        Map<String, String> details = new LinkedHashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(err -> details.put(err.getField(), err.getDefaultMessage()));

        var body = ErrorResponse.of(HttpStatus.BAD_REQUEST.value(), "Validation Error", "Erro de validação", path(req),
                details);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);

    }

    // NÃO MAPEADA (HTTP 500)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(Exception ex, WebRequest req) {

        var body = ErrorResponse.of(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error", "Erro interno",
                path(req));

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    private String path(WebRequest req) {

        String desc = req.getDescription(false);

        int idx = desc.indexOf("uri=");

        return idx >= 0 ? desc.substring(idx + 4) : desc;

    }
}