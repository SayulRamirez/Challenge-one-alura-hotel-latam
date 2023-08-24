package com.alura.hotel.modelo;

public class Huesped {
	
	private int id;
	private String nombre;
	private String apellido;
	private String nacimiento;
	private String nacion;
	private String tel;
	private int idHuesped;
	
	public Huesped(String nombre, String apellido, String nacimiento, String nacion, String tel) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacimiento = nacimiento;
		this.nacion = nacion;
		this.tel = tel;
	}
	
	public Huesped(int id, String nombre, String apellido, String nacimiento, String nacion, String tel) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacimiento = nacimiento;
		this.nacion = nacion;
		this.tel = tel;
	}

	public int getId() {
		return this.id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getNacimiento() {
		return nacimiento;
	}

	public String getNacion() {
		return nacion;
	}

	public String getTel() {
		return tel;
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
