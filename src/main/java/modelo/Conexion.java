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
	private String bd = "reto3_termibus";
	private String username = "hr";
	private String password = "PepeJeans";
	private String params = "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String url = "jdbc:mysql://localhost:3306/"+bd+"?"+params;
	
	private Connection connection = null;
	
	public Conexion() {
		// nos conectanos a la base de datos, si la conexion no es correcta lanzamos una excepcion
		try {
			this.connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
	
	/**Permite retornar la conexión*/
	public Connection getConnection(){
		return connection;
	}

	public void desconectar(){
		connection = null;
	}

}
