package com.alura.hotel.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * {@link Class} Para crear la conexión.
 */
public class ConnectionFactory {

	private DataSource dataSource;

	/**
	 * {@link java.lang.reflect.Constructor} asigna los parametros al {@link DataSource}
	 * como la URL, las licencias y el número de conexiónes activas.
	 */
	public ConnectionFactory() {
		
		var pooledDataSource = new ComboPooledDataSource();
		pooledDataSource.setJdbcUrl("jdbc:mysql://localhost/hotel?useTimeZone=true&serverTimeZone=UTC");
		pooledDataSource.setUser("root");
		pooledDataSource.setPassword("Lacrimosa69*");
		pooledDataSource.setMaxPoolSize(10);
		
		this.dataSource = pooledDataSource;
	}

	/**
	 * Método que intenta realizar la conexión establecida en el {@link DataSource} connfigurada
	 * en el constructor.
	 * @return Connection si se establecio la conexión correctamente de lo contrario
	 * lanza un {@link RuntimeException}.
	 */
	public Connection conectar() {
		try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
