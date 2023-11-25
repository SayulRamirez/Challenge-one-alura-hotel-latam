package com.alura.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alura.hotel.modelo.Huesped;

public class HuespedDao {
	final private Connection con;

	/**
	 * {@link java.lang.reflect.Constructor} que crea la conexión.
	 * @param con
	 */
	public HuespedDao(Connection con){
		this.con = con;
	}

	/**
	 * Registra en la base de datos el {@link Huesped}
	 * @param huesped {@link Huesped} con sus datos.
	 * @return int Id del Huesped.
	 */
	public int registrarHuesped(Huesped huesped) {
		int idHuesped = 0;
		
		try(con){
			final PreparedStatement statement = con.prepareStatement("INSERT INTO huespedes(nombre, apellido, fecha_nacimiento, "
															 + "nacionalidad, telefono, id_usuario) VALUE (?, ?, ?, ?, ?, ?) ", Statement.RETURN_GENERATED_KEYS);
			try(statement){
				
				statement.setString(1, huesped.getNombre());
				statement.setString(2, huesped.getApellido());
				statement.setString(3, huesped.getNacimiento());
				statement.setString(4, huesped.getNacion());
				statement.setString(5, huesped.getTel());
				statement.setInt(6, huesped.getIdUsuario());
				
				statement.executeUpdate();
				
				try(ResultSet rs = statement.getGeneratedKeys();){
				
					if(rs.next()) {
						
						idHuesped = rs.getInt(1);
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
        return idHuesped;
    }

	/**
	 * Modifica la información del huesped.
	 * @param huesped {@link Huesped}
	 * @return int 1 si se modifico correctamente.
	 */
	public int modificar(Huesped huesped) {
		
		try(con){
			final PreparedStatement statement = con.prepareStatement(
					"UPDATE huespedes SET nombre = ?, apellido = ?, fecha_nacimiento =  ?, "
		   		  + "nacionalidad = ?, telefono = ? WHERE ID = ?");
			
			try(statement){
				statement.setString(1, huesped.getNombre());
				statement.setString(2, huesped.getApellido());
				statement.setString(3, huesped.getNacimiento());
				statement.setString(4, huesped.getNacion());
				statement.setString(5, huesped.getTel());
				statement.setInt(6, huesped.getId());
				
				statement.execute();
				
				return statement.getUpdateCount();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Elimina los datos del huesped.
	 * @param idHuespedEliminar int Id del huesped
	 * @return
	 */
	public int eliminar(Integer idHuespedEliminar) {

		try(con){
			final PreparedStatement statement = con.prepareStatement("DELETE FROM huespedes WHERE id = ?");
			
			try(statement){
				
				statement.setInt(1, idHuespedEliminar);
				statement.execute();
				
				return statement.getUpdateCount();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}