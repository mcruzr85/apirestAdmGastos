package com.javaupskilling.gastosapp.dao;


import com.javaupskilling.gastosapp.entities.Gasto;
import com.javaupskilling.gastosapp.exceptions.DAOException;

import java.util.List;



public interface GastoRepository {

        //CRUD
        //CREATE
        Integer insert(Gasto gasto) throws DAOException;

        //READ
       // List<GastoDto> getAll() throws DAOException;

        //UPDATE
      //  void update(GastoDto gastoDto) throws DAOException;

        //DELETE

     //   void delete(int id);
       // GastoDto getById(int id) throws DAOException;

    }