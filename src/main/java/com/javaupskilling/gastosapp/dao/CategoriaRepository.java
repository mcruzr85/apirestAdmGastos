package com.javaupskilling.gastosapp.dao;



import com.javaupskilling.gastosapp.entities.Categoria;
import com.javaupskilling.gastosapp.exceptions.DAOException;

import java.util.List;

public interface CategoriaRepository {


    //CRUD
    //CREATE
    Integer insert(Categoria categoria) throws DAOException;
    Categoria getCategoryByName(String name) throws DAOException;

    //READ
    List<Categoria> getAll();

    //UPDATE
    void update(Categoria categoria);

    //DELETE

    void delete(int id);

}
