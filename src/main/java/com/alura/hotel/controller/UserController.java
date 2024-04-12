package com.alura.hotel.controller;

import com.alura.hotel.dao.UsuarioDao;
import com.alura.hotel.factory.ConnectionFactory;
import com.alura.hotel.modelo.Usuario;

public class UserController {

	private UsuarioDao usuarioDao;
	
	public UserController() {
		this.usuarioDao =  new UsuarioDao(new ConnectionFactory().conectar());
	}
	
	public boolean autenticar(Usuario usuario) {
		return usuarioDao.autenticar(usuario);
	}
}
