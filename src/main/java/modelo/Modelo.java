package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Modelo {
	
	private Connection connection = null;
	
	public Modelo() {
		connection = new Conexion().getConnection();
	}
	
	public ArrayList<Linea> getLineas() {
		
		PreparedStatement stmt = null;
		ResultSet result = null;
		Linea linea = null;
		ArrayList<Linea> lineas = new ArrayList<Linea>();

		try {
			
			// preparamos la consulta SQL a la base de datos
			stmt = this.connection.prepareStatement("SELECT * FROM linea");
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			result = stmt.executeQuery();
			
			// crea objetos con los resultados y los a�ade a un arrayList
			while (result.next()) {
				linea = new Linea();
				linea.setCodLinea(result.getString("Cod_Linea"));
				linea.setNombre(result.getString("Nombre"));
				lineas.add(linea);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}           
		
		return lineas;
		
	}
	
	public ArrayList<Parada> getParadasByLinea(String codLinea) {
		
		PreparedStatement stmt = null;
		ResultSet result = null;
		Parada parada = null;
		ArrayList<Parada> paradas = new ArrayList<Parada>();

		try {
			
			// preparamos la consulta SQL a la base de datos
			stmt = this.connection.prepareStatement("SELECT Cod_Parada FROM `linea-parada` where Cod_Linea = ?");
			stmt.setString(1, codLinea);
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			result = stmt.executeQuery();
			
			// crea objetos con los resultados y los a�ade a un arrayList
			while (result.next()) {
				parada = new Parada();
				parada.setCodParada(result.getInt("Cod_Parada"));
				parada = getInfoParada(parada);
				paradas.add(parada);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}           
		
		return paradas;
		
	}
	
	public Parada getInfoParada(Parada parada) {
		
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			
			// preparamos la consulta SQL a la base de datos
			stmt = this.connection.prepareStatement("SELECT Nombre, Calle, Latitud, Longitud FROM parada where Cod_Parada = ?");
			stmt.setInt(1, parada.getCodParada());
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			result = stmt.executeQuery();
			
			// crea objetos con los resultados y los a�ade a un arrayList
			while (result.next()) {
				parada.setNombre(result.getString("Nombre"));
				parada.setCalle(result.getString("Calle"));
				parada.setLatitud(result.getFloat("Latitud"));
				parada.setLongitud(result.getFloat("Longitud"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}           
		
		return parada;
		
	}
	
}
