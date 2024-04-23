package com.alura.hotel.controller;

import com.alura.hotel.dao.ReservacionDao;
import com.alura.hotel.factory.ConnectionFactory;
import com.alura.hotel.modelo.Reservacion;

public class ReservacionController {
	private final ReservacionDao reservacionDao;
	
	public ReservacionController() {
		this.reservacionDao = new ReservacionDao();
	}
	public int registrarReservacion(Reservacion reserva) {
		return reservacionDao.registrarReservacion(reserva);
	}
	public int modificar(Reservacion reservacion) {
		return reservacionDao.modificar(reservacion);
	}
	public int eliminar(Integer idReserva) {
		return reservacionDao.eliminar(idReserva);
	}
}