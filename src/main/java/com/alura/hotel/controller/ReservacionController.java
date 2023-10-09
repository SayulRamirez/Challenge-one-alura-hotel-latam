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
	
	public void registrarReservacion(Reservacion reserva) {
		
		reservacionDao.registrarReservacion(reserva);
	}

	public void setIdHuesped(Reservacion reservacion, int idHuesped) {

		reservacionDao.setIdHuesped(reservacion, idHuesped);
	}

	public Reservacion cargarDatos(int parametro) {
		return reservacionDao.cargarDatos(parametro);
	}
	
	public List<Reservacion> cargarDatos(List<Integer> ids) {
		return reservacionDao.cargarDatos(ids);
	}

	public int modificar(Reservacion reservacion) {
		// TODO Auto-generated method stub
		return reservacionDao.modificar(reservacion);
	}

	public int eliminar(Integer idReserva) {
		return reservacionDao.eliminar(idReserva);
	}

}
