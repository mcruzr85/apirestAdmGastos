package com.javaupskilling.gastosapp.dao;



import com.javaupskilling.gastosapp.entities.Categoria;
import com.javaupskilling.gastosapp.exceptions.DAOException;

import java.util.List;

public interface CategoriaRepository {


    //CRUD
    //CREATE
    Integer insert(Categoria categoria) throws DAOException;
    Categoria getCategoryByName(String name) throws DAOException;
    Categoria getCategoryById(Long id) throws DAOException;

    //READ
    List<Categoria> getAll() throws DAOException;

    //UPDATE
    Integer update(Categoria categoria, Long id) throws DAOException;

    //DELETE

    int delete (long id) throws DAOException;

}
