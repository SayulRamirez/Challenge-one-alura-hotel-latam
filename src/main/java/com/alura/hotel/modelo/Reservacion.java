package com.alura.hotel.modelo;

public class Reservacion {
	
	private int id;
	private String fechaIngreso;
	private String fechaEgreso;
	private String costo;
	private String formaPago;
	private int idHuesped;
	
	
	public Reservacion(String fechaIngreso, String fechaEgreso, String costo, String formaPago ) {
		
		this.fechaIngreso = fechaIngreso;
		this.fechaEgreso = fechaEgreso;
		this.costo = costo;
		this.formaPago = formaPago;
	}

	public int getId() {
		return id;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public String getFechaEgreso() {
		return fechaEgreso;
	}

	public String getCosto() {
		return costo;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public int getidHuesped() {
		return idHuesped;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIdHuesped(int id) {
		this.idHuesped = id;
	}
}
