package com.alura.hotel.dao;

import com.alura.hotel.factory.ConnectionFactory;
import com.alura.hotel.modelo.Huesped;
import com.alura.hotel.modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NewUsuarioDao {

    private final Connection con;

    public NewUsuarioDao(){
        this.con = new ConnectionFactory().conectar();
    }

    /**
     * Crea un nuevo {@link Usuario} con la información recibida.
     * @param usuarioNew {@link Usuario}
     * @param dataNewHuesped {@link Huesped}
     */
    public void createNewUser(Usuario usuarioNew, Huesped dataNewHuesped) {

        try(con){

            final PreparedStatement statement = con.prepareStatement("INSERT INTO usuarios(nombre_usuario, contrasena) VALUES (?, ?)");
            final PreparedStatement statement1 = con.prepareStatement("INSERT INTO huespedes(nombre, apellido, fecha_nacimiento, nacionalidad, telefono, id_usuario) " +
                    "VALUES (?, ?, ?, ?,  ?, (SELECT id FROM usuarios WHERE nombre_usuario = ? AND contrasena = ?));");

                try(statement; statement1){

                    String user = usuarioNew.getUsuario();
                    String pass = usuarioNew.getPass();

                    statement.setString(1, user);
                    statement.setString(2, pass);

                    statement1.setString(1, dataNewHuesped.getNombre());
                    statement1.setString(2, dataNewHuesped.getApellido());
                    statement1.setString(3, dataNewHuesped.getNacimiento());
                    statement1.setString(4, dataNewHuesped.getNacion());
                    statement1.setString(5, dataNewHuesped.getTel());
                    statement1.setString(6, user);
                    statement1.setString(7, pass);

                    statement.execute();
                    statement1.execute();
                }
        } catch (SQLException sqlException){
            throw new RuntimeException(sqlException);
        }
    }
}
