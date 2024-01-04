package com.javaupskilling.gastosapp.service.impl;

import com.javaupskilling.gastosapp.dao.GastoRepository;
import com.javaupskilling.gastosapp.dto.request.GastoRequestDto;
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

    private Gasto mapRequestDtoToGasto(GastoRequestDto gastoRequestDto) {
        Gasto gasto = new Gasto();
        //newGasto.setCategoriaId(gastoRequestDto.getCategoriaId());

        gasto.setDescripcion(gastoRequestDto.getDescripcion());
        gasto.setValor(gastoRequestDto.getAmount());
        gasto.setFecha(gastoRequestDto.getFecha());
        gasto.setCategoriaNombre(gastoRequestDto.getCategoriaRequestDto().getNombre());
        return gasto;
    }
}
//el servicio se encarga de inyectar el Repositorio, se encarga de la logica o sea del mapeo del RequestDto
//a la entidad que vamos a pasar al Repositorio o capa de acceso a Datos
