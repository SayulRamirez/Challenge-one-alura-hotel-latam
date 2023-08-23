package com.alura.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.alura.hotel.modelo.Reservacion;

public class ReservaDao {
	
	final private Connection  con;
	
	public ReservaDao(Connection con) {
		this.con = con;
	}
	
	
	public void registrarReserva(Reservacion reserva) {
		
		try(con){
			
			final PreparedStatement statement = con.prepareStatement(
										"INSERT INTO reservaciones("
										+ "fecha_ingreso, fecha_egreso, valor, forma_pago, id_huesped) VALUE("
										+ "?, ?, ?, ?, ?)");
			try(statement){
				
				statement.setString(1, reserva.getFechaIngreso());
				statement.setString(2, reserva.getFechaEgreso());
				statement.setString(3, String.valueOf(reserva.getCosto()));
				statement.setInt(4, reserva.getId());
				
				statement.execute();
			}
			
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	

}
