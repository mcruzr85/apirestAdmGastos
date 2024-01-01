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
        gastoRepository.insert(gasto);
        return null;
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