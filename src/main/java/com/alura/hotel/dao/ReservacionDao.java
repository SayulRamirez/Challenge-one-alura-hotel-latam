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

                return statement.getUpdateCount();
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

                return statement.getUpdateCount();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}