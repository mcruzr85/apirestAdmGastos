package com.javaupskilling.gastosapp.controller;


import com.javaupskilling.gastosapp.dto.request.CategoriaRequestDto;
import com.javaupskilling.gastosapp.exceptions.DAOException;
import com.javaupskilling.gastosapp.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

@Autowired
    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<String> createCategoriaHandler(@RequestBody CategoriaRequestDto categoriaRequestDto) throws DAOException {
        //devuelve obj de Spring que nos permite devolver entidades como respuesta de los endpoints

        String response = categoriaService.createCategoria(categoriaRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
        //Devolvemos un obj de ResponseEntity, tiene el metodo status para darle contenido a la respuesta HTTP
        // (HttpStatus es un enumerable con el metodo CREATED) y luego usamos el body para pasarle el response que es un String
    }
}
