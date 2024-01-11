package com.javaupskilling.gastosapp.service.impl;

import com.javaupskilling.gastosapp.dao.CategoriaRepository;
import com.javaupskilling.gastosapp.dto.request.CategoriaRequestDto;
import com.javaupskilling.gastosapp.dto.response.CategoriaResponseDto;
import com.javaupskilling.gastosapp.dto.response.GastoResponseDto;
import com.javaupskilling.gastosapp.entities.Categoria;
import com.javaupskilling.gastosapp.entities.Gasto;
import com.javaupskilling.gastosapp.exceptions.DAOException;
import com.javaupskilling.gastosapp.service.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
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
        return response;
    }


    //pendiente convertir entidades a ResponseDto
    @Override
    public List<CategoriaResponseDto> getAll() throws DAOException {

        List<Categoria> categorias = categoriaRepository.getAll();
        if(categorias.isEmpty()){
            throw new DAOException("No existen categorias");
        }
        List<CategoriaResponseDto> responseDtos = categorias.stream().map(e -> mapCategoriaToResponseDto(e)).collect(Collectors.toList());
       return responseDtos;
    }

    @Override
    public CategoriaResponseDto getCategoriaById(Long id) throws DAOException {
        Categoria categoria = categoriaRepository.getCategoryById(id);
        if(categoria.getId().equals(0)) {
            throw new DAOException("No existe una categoria con ese Id");
            // En este caso, estoy ahorrando el uso de una variable temporal
            // y devolviendo directamente el resultado del método privado para devolver un DTO
        }
        return mapCategoriaToResponseDto(categoria);
    }

    @Override
    public String deleteCategoria(Long id) throws DAOException {

            String response = "Categoría eliminada con éxito";
            Integer affectedRows = categoriaRepository.delete(id);
            if(affectedRows.equals(0)){
                throw new DAOException("No se pudo eliminar esa categoria, no existe ese Id");
            }
            return response;
    }

    @Override
    public String updateCategoria(CategoriaRequestDto categoriaRequestDto, Long id) throws DAOException {
        String response = "Categoría actualizada con éxito";

        Categoria categoria = mapRequestDtoToCategoria(categoriaRequestDto);


        Integer affectedRows = categoriaRepository.update(categoria, id);
        //si devuelve 0 no hubo filas afectadas o actualizadas
        if(affectedRows.equals(0)) throw new DAOException("No se pudo actualizar la categoria, Id no encontrado");
        return response;
    }

    // Método privado para mapear una RequestDto que llega  como objeto para interactuar con la bd
    Categoria mapRequestDtoToCategoria(CategoriaRequestDto categoriaRequestDto){
        Categoria categoria = new Categoria();
        categoria.setNombre(categoriaRequestDto.getNombre());
        categoria.setId(categoriaRequestDto.getId());
        return categoria;
   }

    // Método privado para mapear una entidad que sale hacia una respuesta como objeto DTO
    private CategoriaResponseDto mapCategoriaToResponseDto(Categoria categoria) {
        CategoriaResponseDto categoriaResponseDto = new CategoriaResponseDto();
        categoriaResponseDto.setId(categoria.getId());
        categoriaResponseDto.setNombre(categoria.getNombre());
        return categoriaResponseDto;
    }


}
