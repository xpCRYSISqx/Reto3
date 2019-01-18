package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LineaDAO {
	
	private Connection connection;
	private PreparedStatement stmt;
	private ResultSet result;
	
	public LineaDAO(Connection connection) {
		this.connection = connection;
	}
	
	private void selectLinea() {
		
	}
	
	public ResultSet selectLineasAll() {

			
//		// preparamos la consulta SQL a la base de datos
//		this.stmt = this.connection.prepareStatement("SELECT * FROM linea");
//		//stmt.setString(1,"1234");
//
//		// Ejecuta la consulta y guarda los resultados en un objeto ResultSet              
//		this.result = this.stmt.executeQuery(); 
	
		
		return this.result;
		
	}

}
