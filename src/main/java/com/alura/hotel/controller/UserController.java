package com.alura.hotel.controller;

import com.alura.hotel.dao.UsuarioDao;
import com.alura.hotel.factory.ConnectionFactory;
import com.alura.hotel.modelo.Usuario;

public class UserController {

	private final UsuarioDao usuarioDao;
	
	public UserController() {
		this.usuarioDao =  new UsuarioDao();
	}
	
	public boolean autenticar(Usuario usuario) {
		return usuarioDao.autenticar(usuario);
	}
}
