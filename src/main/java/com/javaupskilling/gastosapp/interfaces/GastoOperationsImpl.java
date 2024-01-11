package com.javaupskilling.gastosapp.interfaces;

import com.javaupskilling.gastosapp.dto.request.GastoRequestDto;
import com.javaupskilling.gastosapp.entities.Gasto;

import java.util.List;

public class GastoOperationsImpl implements GastoOperations{
    @Override
    public double calculateGasto(Gasto gasto) {
        return gasto.getValor();
    }

    @Override
    public double calculateTotalGastos(List<GastoRequestDto> gastos) {
        double total = 0;
         for(GastoRequestDto gastoDto : gastos){
             total += gastoDto.getAmount();
         }
         return total;
    }
}
