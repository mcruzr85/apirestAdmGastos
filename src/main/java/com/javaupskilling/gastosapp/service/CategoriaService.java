package com.javaupskilling.gastosapp.service;

import com.javaupskilling.gastosapp.dto.request.CategoriaRequestDto;
import com.javaupskilling.gastosapp.dto.response.CategoriaResponseDto;
import com.javaupskilling.gastosapp.entities.Categoria;
import com.javaupskilling.gastosapp.exceptions.DAOException;

import java.util.List;

public interface CategoriaService {
    String createCategoria(CategoriaRequestDto categoriaRequestDto) throws DAOException;
    List<CategoriaResponseDto> getAll() throws DAOException;
    CategoriaResponseDto getCategoriaById(Long id) throws DAOException;

    String deleteCategoria(Long id) throws DAOException;
    String updateCategoria(CategoriaRequestDto categoriaRequestDto, Long id) throws DAOException;
}
