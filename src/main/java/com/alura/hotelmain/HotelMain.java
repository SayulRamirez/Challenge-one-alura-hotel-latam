package com.alura.hotelmain;

import javax.swing.JFrame;

import com.alura.hotel.view.MenuPrincipal;

public class HotelMain {

	public static void main(String[] args) {

		MenuPrincipal inicioAplicacion = new MenuPrincipal();
		inicioAplicacion.setVisible(true);
		inicioAplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
