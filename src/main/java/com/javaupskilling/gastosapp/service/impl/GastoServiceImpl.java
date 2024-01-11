package com.javaupskilling.gastosapp.service.impl;

import com.javaupskilling.gastosapp.dao.GastoRepository;
import com.javaupskilling.gastosapp.dto.request.GastoRequestDto;
import com.javaupskilling.gastosapp.dto.response.CategoriaResponseDto;
import com.javaupskilling.gastosapp.dto.response.GastoResponseDto;
import com.javaupskilling.gastosapp.entities.Gasto;
import com.javaupskilling.gastosapp.exceptions.DAOException;
import com.javaupskilling.gastosapp.service.GastoService;
import org.springframework.stereotype.Service;

@Service
public class GastoServiceImpl implements GastoService {

    private final GastoRepository gastoRepository;

    public GastoServiceImpl(GastoRepository gastoRepository) {

        this.gastoRepository = gastoRepository;
    }


    @Override
    public String createGasto(GastoRequestDto gastoRequestDto) throws DAOException {

        String response = "Se registró el gasto con exito";
        Gasto gasto = mapRequestDtoToGasto(gastoRequestDto);

        Integer responseInserted = gastoRepository.insert(gasto);

        if(responseInserted.equals(0)){
            System.out.println("No se insertó el gasto");
        }

        return response;
    }

    /**
     *     @Override
     *     public ExpenseResponseDto getExpenseById(Long id) {
     *         Expense expense = expenseRepository.selectExpenseById(id);
     *         // En este caso, estoy ahorrando el uso de una variable temporal
     *         // y devolviendo directamente el resultado del método privado
     *         return mapExpenseToResponseDto(expense);
     */



/*@Override
    public List<ExpenseResponseDto> getAllExpenses() {
        List<Expense> expenses = expenseRepository.selectExpenses();

        // En este caso, estoy ahorrando el uso de una variable temporal para la lista
        // y devolviendo directamente el resultado de la llamada funcional
        // que colecciona todos los objetos de tipo respuesta, resultado del método mapper
        return expenses.stream()
                .map(this::mapExpenseToResponseDto)
                .collect(Collectors.toList());
    }
*/



    // Método privado para mapear objetos DTO de entrada a entidad para manipular en la BD
    private Gasto mapRequestDtoToGasto(GastoRequestDto gastoRequestDto) {
        Gasto gasto = new Gasto();
        //newGasto.setCategoriaId(gastoRequestDto.getCategoriaId());

        gasto.setDescripcion(gastoRequestDto.getDescripcion());
        gasto.setValor(gastoRequestDto.getAmount());
        gasto.setFecha(gastoRequestDto.getFecha());
        gasto.setCategoriaNombre(gastoRequestDto.getCategoriaRequestDto().getNombre());
        return gasto;
    }


    // Método privado para mapear una entidad que sale hacia una respuesta como objeto DTO
    private GastoResponseDto mapGastoToResponseDto(Gasto gasto) {
        GastoResponseDto gastoResponseDto = new GastoResponseDto();
        gastoResponseDto.setValor(gasto.getValor());

        CategoriaResponseDto categoriaResponseDto = new CategoriaResponseDto();
        categoriaResponseDto.setId(gasto.getId());
        categoriaResponseDto.setNombre(gasto.getCategoriaNombre());

        gastoResponseDto.setCategoriaResponseDto(categoriaResponseDto);
        gastoResponseDto.setFecha(gasto.getFecha());
        return gastoResponseDto;
    }
}
//el servicio se encarga de inyectar el Repositorio, se encarga de la logica o sea del mapeo del RequestDto
//a la entidad que vamos a pasar al Repositorio o capa de acceso a Datos
