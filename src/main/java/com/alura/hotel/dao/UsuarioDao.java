package com.alura.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alura.hotel.modelo.Usuario;

public class UsuarioDao {
	
	final private Connection con;

	/**
	 * {@link java.lang.reflect.Constructor} crea una conexión.
	 * @param con {@link Connection}
	 */
	public UsuarioDao(Connection con) {
		this.con = con;
	}

	/**
	 * Auntentica que el usuario esta registrado en el sistema.
	 * @param usuario {@link Usuario}
	 * @return boolean true si esta registrado o false si no esta registrado.
	 */
	public boolean autenticar(Usuario usuario) {
		
		try(con){
			
			final PreparedStatement statement = con.prepareStatement("SELECT id FROM usuarios WHERE nombre_usuario = ? AND contrasena = ? ;");
			
			try(statement){
				
				statement.setString(1, usuario.getUsuario());
				statement.setString(2, usuario.getPass());
				
				try(ResultSet resultset = statement.executeQuery();){
					
					if(resultset.next()) {
						usuario.setId(resultset.getInt("id"));
						return true;
					} else {
						return false;
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
