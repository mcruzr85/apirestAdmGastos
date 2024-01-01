package com.javaupskilling.gastosapp.service;

import com.javaupskilling.gastosapp.dto.request.GastoRequestDto;

public interface GastoService {
    String createGasto(GastoRequestDto gastoRequestDto);
}
