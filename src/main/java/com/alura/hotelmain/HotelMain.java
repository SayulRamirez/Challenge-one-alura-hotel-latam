package com.alura.hotelmain;

import javax.swing.JFrame;

import com.alura.hotel.view.MainMenu;

/**
 * @author Saul Ramirez (Sayul Ramirez)
 */
public class HotelMain {
	public static void main(String[] args) {

		MainMenu inicioAplicacion = new MainMenu();
		inicioAplicacion.setVisible(true);
		inicioAplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
