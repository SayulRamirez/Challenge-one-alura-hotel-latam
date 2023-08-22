package com.alura.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao {
	
	final private Connection con;
	
	public UsuarioDao(Connection con) {
		this.con = con;
	}
	
	public boolean autenticar(String usuario, String contrasena) {
		
		try(con){
			
			final PreparedStatement statement = con.prepareStatement("SELECT * FROM usuarios WHERE nombre_usuario = ? AND contraseña = ? ;");
			
			try(statement){
				
				statement.setString(1, usuario);
				statement.setString(2, contrasena);
				
				ResultSet resultset = statement.executeQuery();
				
				return resultset.next();
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
 
}
