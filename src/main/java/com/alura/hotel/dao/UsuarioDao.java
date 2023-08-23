package com.alura.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alura.hotel.modelo.Usuario;

public class UsuarioDao {
	
	final private Connection con;
	
	public UsuarioDao(Connection con) {
		this.con = con;
	}
	
	public boolean autenticar(Usuario usuario) {
		
		try(con){
			
			final PreparedStatement statement = con.prepareStatement("SELECT * FROM usuarios WHERE nombre_usuario = ? AND contraseña = ? ;");
			
			try(statement){
				
				statement.setString(1, usuario.getUsuario());
				statement.setString(2, usuario.getPass());
				
				try(ResultSet resultset = statement.executeQuery();){
					
					if(resultset.next()) {
						
						usuario.setId(resultset.getInt("id"));
						System.out.println(usuario.getId());
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
