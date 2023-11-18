package com.alura.hotel.controller;

import java.util.List;

import com.alura.hotel.dao.HuespedDao;
import com.alura.hotel.factory.ConnectionFactory;
import com.alura.hotel.modelo.Huesped;

public class HuespedController {
	private HuespedDao huespedDao;
	
	public HuespedController() {
		this.huespedDao = new HuespedDao(new ConnectionFactory().conectar());
	}
	
	public int registrarHuesped(Huesped huesped) {
		return huespedDao.registrarHuesped(huesped);
	}

	public List<Huesped> cargarDatos(String parametro) {
		return huespedDao.cargarDatos(parametro);
	}

	public Huesped cargarDatos(int idHuesped) {
		return huespedDao.cargarDatos(idHuesped);
	}

	public int modificar(Huesped huesped) {
		return huespedDao.modificar(huesped);
	}

	public int eliminar(Integer idHuespedEliminar) {
		return huespedDao.eliminar(idHuespedEliminar);
	}

}