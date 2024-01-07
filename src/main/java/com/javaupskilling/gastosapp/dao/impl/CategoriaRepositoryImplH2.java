package com.javaupskilling.gastosapp.dao.impl;

import com.javaupskilling.gastosapp.dao.CategoriaRepository;
import com.javaupskilling.gastosapp.dao.dto.CategoriaDto;
import com.javaupskilling.gastosapp.entities.Categoria;
import com.javaupskilling.gastosapp.exceptions.DAOException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class CategoriaRepositoryImplH2 implements CategoriaRepository {

    private static final String INSERT_INTO_CATEGORY = "INSERT INTO ExpenseCategory (name) VALUES (?)";
    private static final String GET_CATEGORY_BY_NAME = "SELECT * FROM ExpenseCategory WHERE name = ?";

    private final JdbcTemplate jdbcTemplate;

    public CategoriaRepositoryImplH2(JdbcTemplate jdbcTemplate){

        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Integer insert(Categoria categoria) throws DAOException {

       return jdbcTemplate.update(INSERT_INTO_CATEGORY, categoria.getNombre().toLowerCase());
        //update devuelve un entero con la cantidad de filas afectadas
    }

    @Override
    public Categoria getCategoryByName(String name) throws DAOException {
        return null;
    }

    @Override
    public List<Categoria> getAll() {
        return null;
    }

    @Override
    public void update(Categoria categoria) {

    }

    @Override
    public void delete(int id) {

    }


/*
    @Override
    public Categoria getCategoryByName(String name) throws DAOException {

        System.out.println("nombre de la categoria a buscar: " + name);

        try( PreparedStatement ps = connection.prepareStatement(GET_CATEGORY_BY_NAME)){

            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();
           if(rs.next()){
               Categoria newCategoria =  new Categoria(rs.getLong("id_cat") , rs.getString("nombre")) ;
               System.out.println(newCategoria.getId() + " " + newCategoria.getNombre());
               categoria = mapCategoriaToDto(newCategoria);
               System.out.println(categoria.getId() + " " + categoria.getNombre());
               return categoria;
           }
           return null;


        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Categoria> getAll() {
        return null;
    }

    @Override
    public void update(Categoria categoria) {

    }

    @Override
    public void delete(int id) {

    }*/




}
