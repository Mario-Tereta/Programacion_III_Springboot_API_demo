package com.ejemplo.demo.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ejemplo.demo.api.dto.PrestamoRequest;
import com.ejemplo.demo.api.dto.PrestamoResponse;
import com.ejemplo.demo.domain.service.PrestamoService;
import com.ejemplo.demo.generated.api.SimulacionesApi;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/simulaciones")
public class SimulacionController implements SimulacionesApi {

    private final PrestamoService prestamoService;

    public SimulacionController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @Override
    @PostMapping("/prestamo")
    public ResponseEntity<PrestamoResponse> simularPrestamo(
            @Valid @RequestBody PrestamoRequest request
    ) {

        return ResponseEntity.ok(
                prestamoService.simularPrestamo(request)
        );
    }
}