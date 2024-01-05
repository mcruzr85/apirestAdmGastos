package com.javaupskilling.gastosapp.dao.impl;

import com.javaupskilling.gastosapp.dao.GastoRepository;

import com.javaupskilling.gastosapp.entities.Categoria;
import com.javaupskilling.gastosapp.entities.Gasto;
import com.javaupskilling.gastosapp.exceptions.DAOException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


//import javax.swing.tree.RowMapper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

@Repository
public class GastoRepositoryImplH2 implements GastoRepository {

    private static final String INSERT_INTO_EXPENSE = "INSERT INTO Expense (description, amount, category_id, category_name,date) VALUES (?, ?, ?, ?, ?)";
    private static final String GET_ALL_EXPENSES = "SELECT * FROM Expense";
    private static final String GET_EXPENSE_BY_ID = "SELECT * FROM Expense WHERE id = ?";
    private static final String UPDATE_EXPENSE = "UPDATE Expense SET amount = ?, category_id =?, date = ? WHERE id = ? ";
    private static final String DELET_EXPENSE = "DELETE FROM Expense WHERE id = ?";
    private static final String INSERT_INTO_CATEGORY_EXPENSE = "INSERT INTO ExpenseCategory (name) VALUES (?)";
    private static final String SELECT_FROM_EXPENSE_CATEGORY_BY_NAME = "SELECT * FROM ExpenseCategory WHERE name = ?";


    //generando una instancia de conexion que tiene que ser provista por otro obj
   private final JdbcTemplate jdbcTemplate;

    public GastoRepositoryImplH2(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer insert(Gasto gasto) throws  DAOException{
        jdbcTemplate.update(INSERT_INTO_CATEGORY_EXPENSE, gasto.getCategoriaNombre().toLowerCase());
        Object[] params = {gasto.getCategoriaNombre()};
        int[] types = {1};
       Categoria categoria = jdbcTemplate.queryForObject(
               SELECT_FROM_EXPENSE_CATEGORY_BY_NAME,
               params, types,
               new CategoriaRowMapper());
       return jdbcTemplate.update(INSERT_INTO_EXPENSE,
               gasto.getDescripcion(),
               gasto.getValor(),
               categoria.getId(),
               categoria.getNombre(),
               gasto.getFecha());
       //update devuelve un entero con la cantidad de filas afectadas
    }



/*

    @Override
    public List<GastoDto> getAll() throws DAOException {
        List<GastoDto> gastosDto = new ArrayList<>();

        try(PreparedStatement ps = connection.prepareStatement(GET_ALL_EXPENSES)){

            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()){
                gastosDto.add(mapResultSetToGastoDto(resultSet));
            }

            return gastosDto;

        }catch(SQLException e){
            throw new DAOException("Error al recuperar la lista de gastos", e);
        }

    }

    @Override
    public void update(GastoDto gastoDto) {
        try{  //creo la entidad Gasto con los valores que trae el Dto
           Gasto newGasto = new Gasto();

           newGasto.setId(gastoDto.getId());
           newGasto.setDescripcion(gastoDto.getDescripcion());
           newGasto.setValor(gastoDto.getValor());
           newGasto.setFecha(gastoDto.getFecha());
           newGasto.setCategoriaId(gastoDto.getCategoriaId());
           PreparedStatement ps = connection.prepareStatement(
                   "UPDATE expense SET description = ?, date = ?, amount = ? WHERE id_exp = ?");

           ps.setString(1, newGasto.getDescripcion());
           ps.setString(2, newGasto.getFecha());
           ps.setDouble(3, newGasto.getValor());
           ps.setInt(4, newGasto.getId());

           ps.executeUpdate();

        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(int gastoId) {
        try{

            PreparedStatement ps = connection.prepareStatement(
                    "DELETE FROM expense WHERE id_exp = ?"
            );

            ps.setInt(1, gastoId);
            ps.executeUpdate();

        }catch(SQLException e){
            throw new RuntimeException(e);

        }


    }

    @Override
    public GastoDto getById(int id) throws DAOException {
        try(PreparedStatement ps = connection.prepareStatement(GET_EXPENSE_BY_ID)){
           ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return mapResultSetToGastoDto(rs);
            }
            return null;

        }catch(SQLException e){
            throw new DAOException("Error al obtener un asto dado un Id", e);
        }
    }*/
static class CategoriaRowMapper implements RowMapper<Categoria>{
    @Override
    public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException{
        //Para mapear cada campo recuperado de la bd con la prop que corresponden a la entidad
        //el rs mapeado a las props
        Categoria categoria = new Categoria();
        categoria.setId(rs.getLong("id"));
        categoria.setNombre(rs.getString("name"));
        return categoria;
    }
}


    class GastoRowMapper implements RowMapper<Gasto> {
        @Override
        public Gasto mapRow(ResultSet rs, int rowNum) throws SQLException {
            Gasto expense = new Gasto();
            expense.setId((Long) rs.getLong("id"));
            expense.setValor(rs.getDouble("amount"));
            expense.setCategoriaId((int) rs.getLong("category_id"));
            expense.setCategoriaNombre(rs.getString("category_name"));
            expense.setFecha(rs.getString("date"));
            return expense;
        }
    }
}



//Se encarga de hacer el insert en la BD
//Insertamos una caregoria
//recuperamos esa categosia por el nombre
//para poder insertar el gasto junto con el id de la categoria
