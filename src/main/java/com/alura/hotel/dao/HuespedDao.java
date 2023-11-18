package com.alura.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alura.hotel.modelo.Huesped;

public class HuespedDao {
	final private Connection con;
	
	public HuespedDao(Connection con){
		this.con = con;
	}
	
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

	public List<Huesped> cargarDatos(String parametro) {
		List<Huesped> resultado = new ArrayList<>();

		try(con){
			final PreparedStatement statement = con.prepareStatement("SELECT * FROM huespedes WHERE apellido = ?");
			statement.setString(1, parametro);

			try(statement){
			
				statement.execute();
				final ResultSet rls = statement.getResultSet();
				
				while(rls.next()) {
					
					Huesped huesped = new Huesped(rls.getInt("id"),
												  rls.getString("nombre"), 
												  rls.getString("apellido"), 
												  rls.getString("fecha_nacimiento"), 
												  rls.getString("nacionalidad"), 
												  rls.getString("telefono"));
					
					resultado.add(huesped);
				}
				return resultado;
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Huesped cargarDatos(int idHuesped) {
		Huesped huesped= null;
		
		try(con){
			final PreparedStatement statement = con.prepareStatement("SELECT * FROM huespedes WHERE id = ?");
			statement.setInt(1, idHuesped);
			
			try(statement){
				final ResultSet rs = statement.executeQuery();
				
				while(rs.next()) {
					
					huesped = new Huesped(rs.getInt("id"),
							  rs.getString("nombre"), 
							  rs.getString("apellido"), 
							  rs.getString("fecha_nacimiento"), 
							  rs.getString("nacionalidad"), 
							  rs.getString("telefono"));
				}
				return huesped;
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

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
				
				int updateCount = statement.getUpdateCount(); 
				
				return updateCount;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int eliminar(Integer idHuespedEliminar) {

		try(con){
			final PreparedStatement statement = con.prepareStatement("DELETE FROM huespedes WHERE id = ?");
			
			try(statement){
				
				statement.setInt(1, idHuespedEliminar);
				statement.execute();
				
				int updateCount = statement.getUpdateCount();
				
				return updateCount;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}