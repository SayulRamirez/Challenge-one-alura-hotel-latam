package com.alura.hotel.controller;

import com.alura.hotel.dao.UsuarioDao;
import com.alura.hotel.factory.ConnectionFactory;

public class UsuarioController {

	private UsuarioDao usuarioDao;
	
	public UsuarioController() {
		this.usuarioDao =  new UsuarioDao(new ConnectionFactory().conectar());
	}
	
	public boolean autenticar(String usuario, String contrasena) {
		return usuarioDao.autenticar(usuario, contrasena);
	}
}
