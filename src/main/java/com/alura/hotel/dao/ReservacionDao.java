package com.alura.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alura.hotel.factory.ConnectionFactory;
import com.alura.hotel.modelo.Reservacion;

public class ReservacionDao {
	private final Connection con;

	/**
	 * {@link java.lang.reflect.Constructor} crea la conexión.
	 * @param con {@link Connection}
	 */
	public ReservacionDao() {
		this.con = new ConnectionFactory().conectar();
	}

	/**
	 * Registra una nueva reservación.
	 * @param reservacion {@link Reservacion}
	 * @return int Id de la Reservación.
	 */
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

	/**
	 * Modifica los datos dela reservación.
	 * @param reservacion {@link Reservacion}
	 * @return int 1 si la reservación se modifico correctamente.
	 */
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

	/**
	 * Elimina la reservación.
	 * @param idReserva int id de la reservación.
	 * @return int 1 si se modifico correctamente.
	 */
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