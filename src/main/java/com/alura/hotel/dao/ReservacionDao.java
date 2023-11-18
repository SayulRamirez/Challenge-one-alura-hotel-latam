package com.alura.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.alura.hotel.modelo.Reservacion;

public class ReservacionDao {
	final private Connection con;

	public ReservacionDao(Connection con) {
		this.con = con;
	}
	public int registrarReservacion(Reservacion reservacion) {
		int idReservacion = 0;

		try (con) {
			final PreparedStatement statement = con
					.prepareStatement("INSERT INTO reservaciones (fecha_ingreso , fecha_egreso , "
							+ "valor , forma_pago, id_huesped ) VALUE (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

			try (statement) {

				statement.setString(1, reservacion.getFechaIngreso());
				statement.setString(2, reservacion.getFechaEgreso());
				statement.setString(3, reservacion.getCosto());
				statement.setString(4, reservacion.getFormaPago());
				statement.setInt(5, reservacion.getidHuesped());

				statement.executeUpdate();

				try (ResultSet resultset = statement.getGeneratedKeys();) {

					if (resultset.next()) {
						idReservacion = resultset.getInt(1);
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return idReservacion;
	}
	public Reservacion cargarDatos(int parametro) {
		Reservacion reservacion = null;
		
		try(con){
			final PreparedStatement statement = con.prepareStatement("SELECT * FROM reservaciones WHERE id = ?");
			statement.setInt(1, parametro);
			
			try(statement){
				ResultSet rs= statement.executeQuery();
				
				while(rs.next()) {
					
					reservacion = new Reservacion(rs.getInt("id"), 
															  rs.getString("fecha_ingreso"), 
															  rs.getString("fecha_egreso"), 
															  rs.getString("valor"), 
															  rs.getString("forma_pago"), 
																  rs.getInt("id_huesped"));
					}
					return reservacion;
				}
			} catch(SQLException e) {
				throw new RuntimeException(e);
			}
	}
	public List<Reservacion> cargarDatos(List<Integer> ids) {
		List<Reservacion> resultado = new ArrayList<>();
		
		try(con){
			String inClause = String.join(",", Collections.nCopies(ids.size(), "?"));

			final PreparedStatement statement = con.prepareStatement("SELECT * FROM reservaciones WHERE id_huesped IN (" + inClause + ")");

			for (int i = 0; i < ids.size(); i++) {
			    statement.setInt(i + 1, ids.get(i));
			}
			
			try(statement){
				ResultSet rs = statement.executeQuery();;
				
				while(rs.next()) {
					
					Reservacion reservacion = new Reservacion(rs.getInt("id"),
															  rs.getString("fecha_ingreso"), 
															  rs.getString("fecha_egreso"), 
															  rs.getString("valor"), 
															  rs.getString("forma_pago"), 
															  rs.getInt("id_huesped"));
					
					resultado.add(reservacion);
				}
			}
				return resultado;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public int modificar(Reservacion reservacion) {
		try(con){
			final PreparedStatement statement = con.prepareStatement("UPDATE reservaciones SET fecha_ingreso = ?, "
					+ " fecha_egreso = ?, valor = ?, forma_pago = ? WHERE id = ?");
			try(statement){

				statement.setString(1, reservacion.getFechaIngreso());
				statement.setString(2, reservacion.getFechaEgreso());
				statement.setString(3, reservacion.getCosto());
				statement.setString(4, reservacion.getFormaPago());
				statement.setInt(5, reservacion.getId());

				statement.execute();

				int updateCount = statement.getUpdateCount();

				return updateCount;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int eliminar(Integer idReserva) {

		try(con){
			final PreparedStatement statement = con.prepareStatement("DELETE FROM reservaciones WHERE id = ?");

			try(statement){

				statement.setInt(1, idReserva);
				statement.execute();

				int updateCount = statement.getUpdateCount();

				return updateCount;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}