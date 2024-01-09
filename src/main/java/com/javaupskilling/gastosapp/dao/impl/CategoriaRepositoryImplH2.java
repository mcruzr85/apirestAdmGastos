package com.javaupskilling.gastosapp.dao.impl;

import com.javaupskilling.gastosapp.dao.CategoriaRepository;
import com.javaupskilling.gastosapp.dao.dto.CategoriaDto;
import com.javaupskilling.gastosapp.dao.model.CategoriaRowMapper;
import com.javaupskilling.gastosapp.entities.Categoria;
import com.javaupskilling.gastosapp.exceptions.DAOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
    private static final String GET_CATEGORY_BY_ID = "SELECT * FROM ExpenseCategory WHERE id = ?";
    private static final String GET_ALL_CATEGORY = "SELECT * FROM ExpenseCategory";
    private static final String UPDATE_CATEGORY_BY_ID = "UPDATE ExpenseCategory SET name = ? WHERE id = ?";
    private static final String DELETE_CATEGORY_BY_ID = "DELETE FROM ExpenseCategory WHERE id = ?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
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
        Categoria categoria = jdbcTemplate.queryForObject(GET_CATEGORY_BY_NAME,
                new Object[]{name}, new CategoriaRowMapper()
        );
        return categoria;
    }

    //In Spring, we can use jdbcTemplate.queryForObject() to query a
    // single row record from database, and convert the row into an object via row mapper.

    public Categoria getCategoryById(Long id) throws DAOException {
        Categoria categoria = jdbcTemplate.queryForObject(
                GET_CATEGORY_BY_ID,
                new CategoriaRowMapper(),
                new Object[]{id}
        );
        return categoria;
    }

    @Override
    public List<Categoria> getAll() throws DAOException{
        List<Categoria> categorias = jdbcTemplate.query(
                GET_ALL_CATEGORY, new CategoriaRowMapper());
        return categorias;
    }

    @Override
    public Integer update(Categoria categoria, Long id) throws DAOException {
      return jdbcTemplate.update(UPDATE_CATEGORY_BY_ID ,
              categoria.getNombre(),
              id);
    }



    @Override
    public int delete(long id) throws DAOException{
        return jdbcTemplate.update(DELETE_CATEGORY_BY_ID, new Object[]{id});
    }


}
