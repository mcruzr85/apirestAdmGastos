package com.javaupskilling.gastosapp.service.impl;

import com.javaupskilling.gastosapp.dao.CategoriaRepository;
import com.javaupskilling.gastosapp.dto.request.CategoriaRequestDto;
import com.javaupskilling.gastosapp.entities.Categoria;
import com.javaupskilling.gastosapp.exceptions.DAOException;
import com.javaupskilling.gastosapp.service.CategoriaService;

public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }
    @Override
    public String createCategoria(CategoriaRequestDto categoriaRequestDto) throws DAOException {

        String response= "Categoria insertada con éxito";
        Categoria categoria = mapRequestDtoToCategoria(categoriaRequestDto);

        Integer cantAffectedRows = categoriaRepository.insert(categoria);
        if(cantAffectedRows.equals(0)){
            throw new DAOException("Error al insertar la categoria en la base de datos, 0 filas afectadas.");
        }
        return  response;
    }

   Categoria mapRequestDtoToCategoria(CategoriaRequestDto categoriaRequestDto){
        Categoria categoria = new Categoria();
        categoria.setNombre(categoriaRequestDto.getNombre());
        return categoria;
   }
}