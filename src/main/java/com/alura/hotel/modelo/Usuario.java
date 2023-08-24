package com.alura.hotel.modelo;

public class Usuario {

	private int id;
	private String usuario;
	private String pass;
	private int idHuesped;
	
	public Usuario(String usuario, String pass) {
		this.usuario = usuario;
		this.pass = pass;
	}

	public int getId() {
		return id;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public String getPass() {
		return pass;
	}
	
	public int getIdHuesped() {
		return idHuesped;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setIdHuesped(int idHuesped) {
		this.idHuesped = idHuesped;
	}
}
