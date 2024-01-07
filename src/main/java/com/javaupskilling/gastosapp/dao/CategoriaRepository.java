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
    List<Categoria> getAll() throws DAOException;

    //UPDATE
    void update(Categoria categoria) throws DAOException;

    //DELETE

    void delete(int id) throws DAOException;

}
