package com.alura.hotel.controller;

import com.alura.hotel.dao.ReservaDao;
import com.alura.hotel.factory.ConnectionFactory;
import com.alura.hotel.modelo.Reservacion;

public class ReservacionController {
	
	private ReservaDao reservacionDao;
	
	public ReservacionController() {
		
		this.reservacionDao = new ReservaDao(new ConnectionFactory().conectar());
	}
	
	public void registrarReserva(Reservacion reserva) {
		
		reservacionDao.registrarReserva(reserva);
	}

}
