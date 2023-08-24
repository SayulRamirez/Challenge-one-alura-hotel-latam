package com.alura.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alura.hotel.modelo.Huesped;

public class HuespedDao {
	
	final private Connection con;
	
	public HuespedDao(Connection con){
		this.con = con;
	}
	
	public void registrarHuesped(Huesped huesped) {
		
		try(con){
			
			PreparedStatement statement = con.prepareStatement("INSERT INTO huespedes(nombre, apellido, fecha_nacimiento, "
															 + "nacionalidad, telefono) VALUE (?, ?, ?, ?, ?) ", Statement.RETURN_GENERATED_KEYS);
			
			try(statement){
				
				statement.setString(1, huesped.getNombre());
				statement.setString(2, huesped.getApellido());
				statement.setString(3, huesped.getNacimiento());
				statement.setString(4, huesped.getNacion());
				statement.setString(5, huesped.getTel());
				
				statement.executeUpdate();
				
				try(ResultSet rs = statement.getGeneratedKeys();){
				
					if(rs.next()) {
						
						int id = rs.getInt(1);
						huesped.setId(id);
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void setIdUsuario(Huesped huesped, int idUsuario) {

		try (con) {

			PreparedStatement statement = con.prepareStatement("UPDATE huespedes SET id_usuario = ? WHERE id = ?");

			try (statement) {

				statement.setInt(1, idUsuario);
				statement.setInt(2, huesped.getId());
			
					if(statement.executeUpdate() > 0) {
						huesped.setIdHuesped(idUsuario);
				}
			} 
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
