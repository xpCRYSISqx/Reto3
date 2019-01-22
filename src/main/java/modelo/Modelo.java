package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Modelo {
	
	private Connection connection = null;
	private Linea linea = null;	
	
	public Modelo() {
		connection = new Conexion().getConnection();
		linea = new Linea(); 
	}
	
	public ArrayList<Linea> getLineas() {
		
		PreparedStatement stmt = null;
		ResultSet result = null;
		ArrayList<Linea> lineas = new ArrayList<Linea>();

		try {
			
			// preparamos la consulta SQL a la base de datos
			stmt = this.connection.prepareStatement("SELECT * FROM linea");
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			result = stmt.executeQuery();
			
			// crea objetos linea con los resultados y los añade a un arrayList
			while (result.next()) {
				this.linea = new Linea();
				this.linea.setCodLinea(result.getString("Cod_Linea"));
				this.linea.setNombre(result.getString("Nombre"));
				lineas.add(this.linea);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}           
		
		return lineas;
		
	}
	
//	public ArrayList<Linea> getParadas() {
//		
//		PreparedStatement stmt = null;
//		ResultSet result = null;
//		ArrayList<Linea> lineas = new ArrayList<Linea>();
//
//		try {
//			
//			// preparamos la consulta SQL a la base de datos
//			stmt = this.connection.prepareStatement("SELECT * FROM linea");
//			
//			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
//			result = stmt.executeQuery();
//			
//			// crea objetos linea con los resultados y los añade a un arrayList
//			while (result.next()) {
//				this.linea = new Linea();
//				this.linea.setCodLinea(result.getString("Cod_Linea"));
//				this.linea.setNombre(result.getString("Nombre"));
//				lineas.add(this.linea);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}           
//		
//		return lineas;
//		
//	}
}
