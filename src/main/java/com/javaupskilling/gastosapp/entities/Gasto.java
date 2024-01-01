package com.javaupskilling.gastosapp.entities;

public class Gasto {
    //incrementa el contador cada vez que se crea una instancia de GastoReal
    private Integer id;
    private Integer categoriaId;
    private String categoriaNombre;
    private Double valor;
    private String fecha;
    private String descripcion;//el profe no tiene esto

    public Gasto(){
    }

    public Gasto(Integer categoriaId, String categoriaNombre, Double valor, String fecha, String descripcion) {
        this.categoriaId = categoriaId;
        this.categoriaNombre = categoriaNombre;
        this.valor = valor;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }//constructor sin el id

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
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

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getCategoriaNombre() {
        return categoriaNombre;
    }

    public void setCategoriaNombre(String categoriaNombre) {
        this.categoriaNombre = categoriaNombre;
    }

}
