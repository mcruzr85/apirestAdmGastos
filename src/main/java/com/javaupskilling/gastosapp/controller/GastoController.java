package com.javaupskilling.gastosapp.controller;

import com.javaupskilling.gastosapp.dto.request.GastoRequestDto;
import com.javaupskilling.gastosapp.service.GastoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//para que Spring entienda que esta clase es un componente de tipo Rest
@RequestMapping("api/v1/gasto") //para definir una url base

public class GastoController {

    private final GastoService gastoService; //servicio

    public GastoController(GastoService gastoService) { //se pasa el obj servicio x constructor
        this.gastoService = gastoService;
    }

    @PostMapping //peticion de tipo post a la url de arriba
    public ResponseEntity<String> createGastoHandler(@RequestBody GastoRequestDto gastoRequestDto) {
        //devuelve obj de Spring que nos permite devolver entidades como respuesta d elos endpoints

        String response = gastoService.createGasto(gastoRequestDto);
        return null;
    }
}
