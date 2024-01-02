package com.javaupskilling.gastosapp.service;

import com.javaupskilling.gastosapp.dto.request.GastoRequestDto;
import com.javaupskilling.gastosapp.exceptions.DAOException;

public interface GastoService {
    String createGasto(GastoRequestDto gastoRequestDto) throws DAOException;
}
