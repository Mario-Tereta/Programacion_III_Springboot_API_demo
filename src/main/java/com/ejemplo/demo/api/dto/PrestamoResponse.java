package com.ejemplo.demo.api.dto;

import java.math.BigDecimal;

public class PrestamoResponse {

    private BigDecimal cuotaMensual;
    private BigDecimal interesTotal;
    private BigDecimal totalPagar;

    public PrestamoResponse(
            BigDecimal cuotaMensual,
            BigDecimal interesTotal,
            BigDecimal totalPagar
    ) {
        this.cuotaMensual = cuotaMensual;
        this.interesTotal = interesTotal;
        this.totalPagar = totalPagar;
    }

    public BigDecimal getCuotaMensual() {
        return cuotaMensual;
    }

    public BigDecimal getInteresTotal() {
        return interesTotal;
    }

    public BigDecimal getTotalPagar() {
        return totalPagar;
    }
}