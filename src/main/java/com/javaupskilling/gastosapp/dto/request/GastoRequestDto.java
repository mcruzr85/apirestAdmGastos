package com.javaupskilling.gastosapp.dto.request;
//va a ser el obj de entrada a mi app
//es el obj que va a tener los datos que yo quiero pedirle a ese usuario para crear el gasto
public class GastoRequestDto {
    private Double amount;
    private CategoriaRequestDto categoriaRequestDto;
    private String descripcion;
    private String fecha;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public CategoriaRequestDto getCategoriaRequestDto() {
        return categoriaRequestDto;
    }

    public void setCategoriaRequestDto(CategoriaRequestDto categoriaRequestDto) {
        this.categoriaRequestDto = categoriaRequestDto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
