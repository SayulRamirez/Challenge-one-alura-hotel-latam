package com.alura.hotel.controller;

import java.util.List;

import com.alura.hotel.dao.ReservacionDao;
import com.alura.hotel.factory.ConnectionFactory;
import com.alura.hotel.modelo.Reservacion;

public class ReservacionController {
	private ReservacionDao reservacionDao;
	
	public ReservacionController() {
		this.reservacionDao = new ReservacionDao(new ConnectionFactory().conectar());
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