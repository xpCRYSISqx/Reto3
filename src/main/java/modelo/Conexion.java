package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Clase que permite conectar con la base de datos
 * @author laura
 *
 */
public class Conexion {
	
	// datos de conexion
	private String bd;
	private String username;
	private String password;
	private String host;
	private String url;
	private String params;
	
	// variable que almacenara la conexion
	private Connection connection;
	
	public Conexion(String[] datosConexion) {
		
		// inicializamos los atributos
		connection = null;
		host = datosConexion[3];
		bd = datosConexion[0];
		username = datosConexion[1];
		password = datosConexion[2];
		params = "serverTimezone=UTC"; // https://stackoverflow.com/questions/26515700/mysql-jdbc-driver-5-1-33-time-zone-issue
		url = "jdbc:mysql://"+host+":3306/"+bd+"?"+params;
	}
	
	protected Connection conectar(){
		try {
			connection = DriverManager.getConnection(url, username, password);
		} 
		catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
		return connection;
	}

	protected void desconectar(){
		if (connection != null) try { connection.close();} catch (SQLException e) {e.printStackTrace();}
	}

}