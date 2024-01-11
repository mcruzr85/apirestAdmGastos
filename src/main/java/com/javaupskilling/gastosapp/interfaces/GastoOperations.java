package com.javaupskilling.gastosapp.interfaces;

import com.javaupskilling.gastosapp.dto.request.GastoRequestDto;
import com.javaupskilling.gastosapp.entities.Gasto;

import java.util.List;

public interface GastoOperations {
    //como es una interface solo hago la firma o declaracón de los métodos
    //toda la clase que implemente esta interfaz va a poder usar estos comportamientos

    double calculateGasto(Gasto gasto);
    double calculateTotalGastos(List<GastoRequestDto> gasto);


    /*public abstract void addGasto(Gasto gasto);
    public abstract void showGastos();

    public default void checkAmountGasto() {

    }

    public abstract void checkDateGasto();
    public abstract void showGastosFromCategory();*/

}
