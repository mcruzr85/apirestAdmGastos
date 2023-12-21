package com.javaupskilling.gastosapp.dao.dto;

public class CategoriaDto {
    private int id;
    private String nombre;

    public CategoriaDto() {
    }

    public CategoriaDto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
