package com.javaupskilling.gastosapp.dao;

import com.javaupskilling.gastosapp.dao.dto.GastoDto;
import com.javaupskilling.gastosapp.exceptions.DAOException;

import java.util.List;



public interface GastoDao {

        //CRUD
        //CREATE
        void insert(GastoDto gastoDto);

        //READ
        List<GastoDto> getAll() throws DAOException;

        //UPDATE
        void update(GastoDto gastoDto);

        //DELETE

        void delete(int id);
        GastoDto getById(int id) throws DAOException;

    }