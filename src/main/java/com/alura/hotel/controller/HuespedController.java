package com.alura.hotel.controller;

import com.alura.hotel.dao.HuespedDao;
import com.alura.hotel.factory.ConnectionFactory;
import com.alura.hotel.modelo.Huesped;

public class HuespedController {
	
	private HuespedDao huespedDao;
	
	public HuespedController() {
		
		this.huespedDao = new HuespedDao(new ConnectionFactory().conectar());
	}
	
	public void registrarHuesped(Huesped huesped) {
		huespedDao.registrarHuesped(huesped);
	}
	
	public void setIdUsuario(Huesped huesped, int idUsuario) {
		huespedDao.setIdUsuario(huesped, idUsuario);
	}

}
