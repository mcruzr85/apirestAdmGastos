package com.javaupskilling.gastosapp.dto.response;

public class GastoResponseDto {
    private Double valor;
    private CategoriaResponseDto categoriaResponseDto;
    private String fecha;
    private String descripcion;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public CategoriaResponseDto getCategoriaResponseDto() {
        return categoriaResponseDto;
    }

    public void setCategoriaResponseDto(CategoriaResponseDto categoriaResponseDto) {
        this.categoriaResponseDto = categoriaResponseDto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public GastoResponseDto(){}

    public GastoResponseDto(Double valor, CategoriaResponseDto categoriaResponseDto, String fecha, String descripcion) {
        this.valor = valor;
        this.categoriaResponseDto = categoriaResponseDto;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
}
