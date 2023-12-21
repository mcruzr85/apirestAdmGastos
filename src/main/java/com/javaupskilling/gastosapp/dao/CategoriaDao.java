package com.javaupskilling.gastosapp.dao;



import com.javaupskilling.gastosapp.dao.dto.CategoriaDto;
import com.javaupskilling.gastosapp.exceptions.DAOException;

import java.sql.Connection;
import java.util.List;

public interface CategoriaDao {


    //CRUD
    //CREATE
    void insert(CategoriaDto catDto) throws DAOException;
    CategoriaDto getCategoryByName(String name) throws DAOException;

    //READ
    List<CategoriaDto> getAll();

    //UPDATE
    void update(CategoriaDto catDto);

    //DELETE

    void delete(int id);

    public void closeDBConnection() ;
}
