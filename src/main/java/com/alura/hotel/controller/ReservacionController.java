package com.alura.hotel.controller;

import com.alura.hotel.dao.ReservacionDao;
import com.alura.hotel.factory.ConnectionFactory;
import com.alura.hotel.modelo.Reservacion;

public class ReservacionController {
	
	private ReservacionDao reservacionDao;
	
	public ReservacionController() {
		
		this.reservacionDao = new ReservacionDao(new ConnectionFactory().conectar());
	}
	
	public void registrarReservacion(Reservacion reserva) {
		
		reservacionDao.registrarReservacion(reserva);
	}

}
