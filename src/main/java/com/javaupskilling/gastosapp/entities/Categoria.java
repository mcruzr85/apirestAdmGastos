package com.javaupskilling.gastosapp.entities;

public class Categoria {
   private int id;
    private String nombre;

    public Categoria() {
    }

    public Categoria(int id, String nombre) {

        this.id = id;
        this.nombre = nombre;
    }



    public int getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDataCategoria(){
        return "Categoria: " + this.id + " " +  this.nombre;
    }
}
