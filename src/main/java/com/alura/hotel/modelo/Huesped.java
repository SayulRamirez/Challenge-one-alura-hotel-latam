package com.alura.hotel.modelo;

public class Huesped {
	
	private int id;
	private String nombre;
	private String apellido;
	private String nacimiento;
	private String nacion;
	private String tel;
	private int idUsuario;

	public Huesped(String nombre, String apellido, String nacimiento, String nacion, String tel) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.nacimiento = nacimiento;
		this.nacion = nacion;
		this.tel = tel;
	}
	public Huesped(String nombre, String apellido, String nacimiento, String nacion, String tel, int idUsuario) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacimiento = nacimiento;
		this.nacion = nacion;
		this.tel = tel;
		this.idUsuario = idUsuario;
	}
	
	public Huesped(int id, String nombre, String apellido, String nacimiento, String nacion, String tel) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacimiento = nacimiento;
		this.nacion = nacion;
		this.tel = tel;
	}

	public Huesped(int id, String nombre, String apellido, String fechaNacimiento, String nacionalidad, String telefono, int idUsuario) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacimiento = fechaNacimiento;
		this.nacion = nacionalidad;
		this.tel = telefono;
		this.idUsuario = idUsuario;
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

	public int getIdUsuario() {
		return idUsuario;
	}

}
