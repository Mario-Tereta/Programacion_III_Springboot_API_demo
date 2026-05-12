package com.ejemplo.demo.api.controller;

import com.ejemplo.demo.domain.service.PrestamoService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.ejemplo.demo.domain.service.PrestamoService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SimulacionController.class)
class PrestamoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PrestamoService prestamoService;

    @Test
    @DisplayName("Debe simular prestamo correctamente")
    void debeSimularPrestamoCorrectamente() throws Exception {

        mockMvc.perform(post("/api/v1/simulaciones/prestamo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "monto": 10000,
                                  "tasaAnual": 12,
                                  "meses": 12
                                }
                                """))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Debe validar datos invalidos")
    void debeValidarDatosInvalidos() throws Exception {

        mockMvc.perform(post("/api/v1/simulaciones/prestamo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "monto": 0,
                                  "tasaAnual": 0,
                                  "meses": 500
                                }
                                """))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.codigo").value("VALIDATION_ERROR"));
    }
}