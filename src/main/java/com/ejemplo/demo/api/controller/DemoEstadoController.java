package com.ejemplo.demo.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.demo.generated.api.DemoEstadoApi;

@RestController
public class DemoEstadoController implements DemoEstadoApi {

    private static int singletonCounter = 0;

    private int manualCounter = 0;

    @Override
    public ResponseEntity<Integer> obtenerEstadoSingleton() {

        return ResponseEntity.ok(singletonCounter);
    }

    @Override
    public ResponseEntity<Integer> incrementarEstadoSingleton() {

        singletonCounter++;

        return ResponseEntity.ok(singletonCounter);
    }

    @Override
    public ResponseEntity<Integer> obtenerEstadoManual() {

        return ResponseEntity.ok(manualCounter);
    }

    @Override
    public ResponseEntity<Integer> incrementarEstadoManual() {

        manualCounter++;

        return ResponseEntity.ok(manualCounter);
    }
}