package com.alura.hotel.modelo;

public class Usuario {

	private int id;
	private String usuario;
	private String pass;
	
	public Usuario(String usuario, String pass) {
		this.usuario = usuario;
		this.pass = pass;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public String getPass() {
		return pass;
	}
	
	
	
}
