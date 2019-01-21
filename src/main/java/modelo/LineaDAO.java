package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LineaDAO {
	
	private Connection connection;
	private PreparedStatement stmt;
	private ResultSet result;
	private ArrayList<Linea> lineas = new ArrayList<Linea>();
	private Linea linea;
	
	public LineaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public ArrayList<Linea> getLineas() {

		// preparamos la consulta SQL a la base de datos
		try {
			this.stmt = this.connection.prepareStatement("SELECT * FROM linea");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Ejecuta la consulta y guarda los resultados en un objeto ResultSet              
		try {
			this.result = this.stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while (this.result.next()) {
				this.linea = new Linea();
				this.linea.setCodLinea(this.result.getString("Cod_Linea"));
				this.linea.setNombre(this.result.getString("Nombre"));
				this.lineas.add(this.linea);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return this.lineas;
		
	}

}
