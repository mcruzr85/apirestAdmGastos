package com.javaupskilling.gastosapp.interfaces;


import com.javaupskilling.gastosapp.exceptions.InvalidGastoMontoException;

public class GastoMontoValidationImpl implements GastoMontoValidation{
    @Override
    public boolean nonValidMonto(double monto) throws InvalidGastoMontoException {
        if(monto < 0){
            throw new InvalidGastoMontoException("El valor del gasto debe ser mayor que cero");
        }
        return false;
    }
}
