package com.ejemplo.demo.domain.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.ejemplo.demo.api.dto.PrestamoRequest;
import com.ejemplo.demo.api.dto.PrestamoResponse;

@Service
public class PrestamoService {

    public PrestamoResponse simularPrestamo(PrestamoRequest request) {

        double monto = request.getMonto().doubleValue();
        double tasaMensual = request.getTasaAnual().doubleValue() / 12 / 100;
        int meses = request.getMeses();

        double potencia = Math.pow(1 + tasaMensual, meses);

        double cuota =
                monto *
                (tasaMensual * potencia) /
                (potencia - 1);

        double totalPagar = cuota * meses;
        double interesTotal = totalPagar - monto;

        return new PrestamoResponse(
                BigDecimal.valueOf(cuota).setScale(2, RoundingMode.HALF_UP),
                BigDecimal.valueOf(interesTotal).setScale(2, RoundingMode.HALF_UP),
                BigDecimal.valueOf(totalPagar).setScale(2, RoundingMode.HALF_UP)
        );
    }
}