package com.alura.hotel.dao;

import com.alura.hotel.factory.ConnectionFactory;
import com.alura.hotel.modelo.Huesped;
import com.alura.hotel.modelo.Reservacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusquedaDao {

    private final Connection con;

    /**
     * {@link java.lang.reflect.Constructor} Crea la conexion.
     * @param con {@link Connection}
     */
    public BusquedaDao(){
        this.con = new ConnectionFactory().conectar();
    }

    /**
     * Crea una lista de {@link Huesped} y {@link Reservacion} de los datos encontrados
     * con el parametro.
     * @param apellido {@link String}
     * @return Lista de {@link Huesped} y {@link Reservacion}
     */
    public List<Object> cargarDatosPorApellido(String apellido) {
        List<Huesped> resultadoHu = new ArrayList<>();
        List<Reservacion> resultadoRe = new ArrayList<>();

        List<Object> datos = new ArrayList<>();

        try(con){
            final PreparedStatement statementHu = con.prepareStatement("SELECT * FROM huespedes WHERE apellido = ? ;");
            final PreparedStatement statementRe = con.prepareStatement("SELECT * FROM reservaciones WHERE ID_HUESPED IN (SELECT ID FROM huespedes WHERE apellido = ?);");

            statementHu.setString(1, apellido);
            statementRe.setString(1, apellido);

            try(statementHu; statementRe){

                statementHu.execute();
                final ResultSet rlsHue = statementHu.getResultSet();

                statementRe.execute();
                final ResultSet rlsRes = statementRe.getResultSet();

                while(rlsHue.next()) {

                    Huesped huesped = new Huesped(rlsHue.getInt("id"),
                            rlsHue.getString("nombre"),
                            rlsHue.getString("apellido"),
                            rlsHue.getString("fecha_nacimiento"),
                            rlsHue.getString("nacionalidad"),
                            rlsHue.getString("telefono"));

                    resultadoHu.add(huesped);
                }

                while (rlsRes.next()) {

                    Reservacion reservacion = new Reservacion(rlsRes.getInt("id"),
                            rlsRes.getDate("fecha_ingreso").toString(),
                            rlsRes.getDate("fecha_egreso").toString(),
                            rlsRes.getString("valor"),
                            rlsRes.getString("forma_pago"),
                            rlsRes.getInt("id_huesped"));

                    resultadoRe.add(reservacion);
                }

                datos.add(resultadoHu);
                datos.add(resultadoRe);

                return datos;
            }
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Busca la reservación por su identificador y el huesped asociado a ella.
     * @param numeroReserva int Id de la reservación.
     * @return Lista de la reservación encontrada y el huesped al que pertenece.
     */
    public List<Object> cargarDatosPorNumero(int numeroReserva) {
        Reservacion reservacion = null;
        Huesped huesped = null;
        List<Object> datos = new ArrayList<>();

        try(con){
            final PreparedStatement statement = con.prepareStatement("SELECT * FROM reservaciones WHERE id = ? ;");
            final PreparedStatement statementHu = con.prepareStatement("SELECT * FROM huespedes WHERE id = (SELECT id_huesped FROM reservaciones WHERE id = ? );");
            
            statement.setInt(1, numeroReserva);
            statementHu.setInt(1, numeroReserva);

            try(statement; statementHu){
                ResultSet rs= statement.executeQuery();
                ResultSet rsHu = statementHu.executeQuery();

                while(rs.next()) {

                    reservacion = new Reservacion(rs.getInt("id"),
                            rs.getString("fecha_ingreso"),
                            rs.getString("fecha_egreso"),
                            rs.getString("valor"),
                            rs.getString("forma_pago"),
                            rs.getInt("id_huesped"));
                }
                
                while (rsHu.next()) {
                    
                    huesped = new Huesped(
                            rsHu.getInt("id"),
                            rsHu.getString("nombre"),
                            rsHu.getString("apellido"),
                            rsHu.getString("fecha_nacimiento"),
                            rsHu.getString("nacionalidad"),
                            rsHu.getString("telefono"),
                            rsHu.getInt("id_usuario")
                    );
                }
                datos.add(reservacion);
                datos.add(huesped);
                
                return datos;
            }
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
