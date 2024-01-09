package com.javaupskilling.gastosapp.dto.request;

public class CategoriaRequestDto {
    //ya tiene un constructor por defecto que lo hace Java

    private String nombre;
    private Long id;

    public CategoriaRequestDto(String nombre, Long id) {
        this.nombre = nombre;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
