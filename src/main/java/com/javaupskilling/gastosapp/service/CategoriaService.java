package com.javaupskilling.gastosapp.service;

import com.javaupskilling.gastosapp.dto.request.CategoriaRequestDto;
import com.javaupskilling.gastosapp.entities.Categoria;
import com.javaupskilling.gastosapp.exceptions.DAOException;

import java.util.List;

public interface CategoriaService {
    String createCategoria(CategoriaRequestDto categoriaRequestDto) throws DAOException;
    List<Categoria> getAll() throws DAOException;
    Categoria getCategoriaById(Long id) throws DAOException;
}
