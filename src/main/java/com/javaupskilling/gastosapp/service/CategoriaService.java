package com.javaupskilling.gastosapp.service;

import com.javaupskilling.gastosapp.dto.request.CategoriaRequestDto;
import com.javaupskilling.gastosapp.exceptions.DAOException;

public interface CategoriaService {
    String createCategoria(CategoriaRequestDto categoriaRequestDto) throws DAOException;
}
