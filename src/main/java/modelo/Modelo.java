package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Modelo {
	
	private Connection connection = null;
	private Linea linea = null;
	private Parada parada = null;
	
	public Modelo() {
		connection = new Conexion().getConnection();
		linea = new Linea(); 
		parada = new Parada(); 
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
	
//	public ArrayList<Parada> getParadas(String codLinea) {
//		
//		PreparedStatement stmt = null;
//		ResultSet result = null;
//		ArrayList<Parada> paradas = new ArrayList<Parada>();
//
//		try {
//			
//			// preparamos la consulta SQL a la base de datos
//			stmt = this.connection.prepareStatement("SELECT Cod_Parada FROM linea-parada where Cod_Linea = L1");
//			stmt.setString(1, codLinea);
//			
//			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
//			result = stmt.executeQuery();
//			
//			// crea objetos linea con los resultados y los añade a un arrayList
//			while (result.next()) {
//				this.parada = new Parada();
//				this.parada.setCodParada(result.getInt("Cod_Parada"));
//				paradas.add(this.parada);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}           
//		
//		return paradas;
//		
//	}
	
}
