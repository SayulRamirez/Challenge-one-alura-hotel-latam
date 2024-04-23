package com.alura.hotel.controller;

import com.alura.hotel.dao.HuespedDao;
import com.alura.hotel.factory.ConnectionFactory;
import com.alura.hotel.modelo.Huesped;

public class HuespedController {
	private final HuespedDao huespedDao;
	
	public HuespedController() {
		this.huespedDao = new HuespedDao();
	}
	
	public int registrarHuesped(Huesped huesped) {
		return huespedDao.registrarHuesped(huesped);
	}

	public int modificar(Huesped huesped) {
		return huespedDao.modificar(huesped);
	}

	public int eliminar(Integer idHuespedEliminar) {
		return huespedDao.eliminar(idHuespedEliminar);
	}

}