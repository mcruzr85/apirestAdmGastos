package com.javaupskilling.gastosapp.dao.model;

import com.javaupskilling.gastosapp.entities.Categoria;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CategoriaRowMapper implements RowMapper<Categoria> {
    @Override
    public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
        //Para mapear cada campo recuperado de la bd con la prop que corresponden a la entidad
        //el rs mapeado a las props
        return new Categoria(
                rs.getLong("id"),
                rs.getString("name") );
    }
}

//para mapear cada fila obtenida en el result set a su tipo de dato y setearlo al objeto

//When retrieving records from the database you need a way to map the rows to objects.
// This functionality can be added to your application by leveraging a functional interface
// known as RowMapper that provides a method to map the rows to objects.

//Create a class named EmployeeRowMapper under com/twilio/jdbcTemplate/model and implement
// RowMapper with the code below. Override the mapRow()
// method and return a new employee object's specific property retrieved with the ResultSet method.

