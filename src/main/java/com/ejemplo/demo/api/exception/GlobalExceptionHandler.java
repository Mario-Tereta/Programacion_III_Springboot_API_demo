package com.ejemplo.demo.api.exception;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ejemplo.demo.api.dto.ErrorResponse;
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
    public org.springframework.http.ResponseEntity<ErrorResponse>
    manejarErroresValidacion(MethodArgumentNotValidException ex) {

        Map<String, String> detalles = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        detalles.put(
                                error.getField(),
                                error.getDefaultMessage()
                        )
                );

        ErrorResponse response = new ErrorResponse(
                "VALIDATION_ERROR",
                "Uno o mas campos son invalidos",
                Instant.now(),
                detalles
        );

        return org.springframework.http.ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

	 @ExceptionHandler(Exception.class)
	    public org.springframework.http.ResponseEntity<ErrorResponse>
	    manejarErrorGeneral(Exception ex) {

	        ErrorResponse response = new ErrorResponse(
	                "INTERNAL_ERROR",
	                "Ocurrio un error interno",
	                Instant.now(),
	                new HashMap<>()
	        );

	        return org.springframework.http.ResponseEntity
	                .status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(response);
	    }

    /*
    PASO 5 (EJERCICIO):
    Descomenta y adapta este manejador cuando agregues validaciones propias
    en el servicio, por ejemplo IllegalArgumentException.
    */

    @ExceptionHandler(IllegalArgumentException.class)
    public org.springframework.http.ResponseEntity<ErrorResponse>
    manejarErrorNegocio(IllegalArgumentException ex) {

        ErrorResponse response = new ErrorResponse(
                "BUSINESS_RULE_ERROR",
                ex.getMessage(),
                Instant.now(),
                new HashMap<>()
        );

        return org.springframework.http.ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    
}
