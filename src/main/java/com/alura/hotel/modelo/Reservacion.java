package com.alura.hotel.modelo;

public class Reservacion {
	
	private int id;
	
	private String fechaIngreso;
	
	private String fechaEgreso;
	
	private double costo;
	
	private String formaPago;
	
	
	public Reservacion(String fechaIngreso, String fechaEgreso, double costo, String formaPago ) {
		
		this.fechaIngreso = fechaIngreso;
		this.fechaEgreso = fechaEgreso;
		this.costo = costo;
		this.formaPago = formaPago;
	}


	public String getFechaIngreso() {
		return fechaIngreso;
	}


	public String getFechaEgreso() {
		return fechaEgreso;
	}


	public double getCosto() {
		return costo;
	}


	public String getFormaPago() {
		return formaPago;
	}


	public int getId() {
		return id;
	}
	
	

}
