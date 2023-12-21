package com.javaupskilling.gastosapp.entities;

public class Gasto {
    //incrementa el contador cada vez que se crea una instancia de GastoReal
    public static Integer contador = 1;
    private int id;
    private Integer categoriaId;
    private double valor;
    private String fecha;
    private String descripcion;//el profe no tiene esto

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //incrementa el contador cada vez que se crea una instancia de Gasto
    public Gasto(){
    }



    public Gasto( Integer categoriaId,String descripcion, double valor,  String fecha) {
        this.categoriaId = categoriaId;
        this.descripcion = descripcion;
        this.valor = valor;
        this.fecha = fecha;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public static int getContador() {
        return contador;
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

    public String getGastoDescripcion(){
        return getDescripcion() + " por un valor de " + getValor() + " realizado " + getFecha();
    }

    @Override
    public String toString() {
        return "Gasto{" +
                "id=" + id +
                ", categoria=" + categoriaId +
                ", valor=" + valor +
                ", fecha='" + fecha + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
