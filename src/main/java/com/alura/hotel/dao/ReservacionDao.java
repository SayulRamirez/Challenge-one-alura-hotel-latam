package com.alura.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alura.hotel.modelo.Reservacion;

public class ReservacionDao {

	final private Connection con;

	public ReservacionDao(Connection con) {
		this.con = con;
	}

	public void registrarReservacion(Reservacion reservacion) {

		try (con) {

			PreparedStatement statement = con
					.prepareStatement("INSERT INTO reservaciones (fecha_ingreso , fecha_egreso , "
							+ "valor , forma_pago ) VALUE (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

			try (statement) {

				statement.setString(1, reservacion.getFechaIngreso());
				statement.setString(2, reservacion.getFechaEgreso());
				statement.setString(3, reservacion.getCosto());
				statement.setString(4, reservacion.getFormaPago());

				statement.executeUpdate();

				try (ResultSet resultset = statement.getGeneratedKeys();) {

					if (resultset.next()) {
						int id = resultset.getInt(1);
						reservacion.setId(id);
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void setIdHuesped(Reservacion reservacion, int idHuesped) {

		try (con) {

			PreparedStatement statement = con.prepareStatement("UPDATE reservaciones SET id_huesped = ? WHERE id = ?");

			try (statement) {

				statement.setInt(1, idHuesped);
				statement.setInt(2, reservacion.getId());
			
					if(statement.executeUpdate() > 0) {
						reservacion.setIdHuesped(idHuesped);
				}
			} 

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
