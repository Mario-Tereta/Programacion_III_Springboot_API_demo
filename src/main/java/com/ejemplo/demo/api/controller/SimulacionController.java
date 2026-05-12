package com.ejemplo.demo.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.ejemplo.demo.api.dto.PrestamoRequest;
import com.ejemplo.demo.api.dto.PrestamoResponse;
import com.ejemplo.demo.domain.service.PrestamoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/simulaciones")
public class SimulacionController {

    private final PrestamoService prestamoService;

    public SimulacionController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @PostMapping("/prestamo")
    @ResponseStatus(HttpStatus.OK)
    public PrestamoResponse simularPrestamo(
            @Valid @RequestBody PrestamoRequest request
    ) {

        return prestamoService.simularPrestamo(request);
    }
}