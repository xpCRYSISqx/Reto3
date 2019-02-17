package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Clase que permite conectar con la base de datos
 * @author laura
 *
 */
public class Conexion {
	
	private String bd;
	private String username;
	private String password;
	private String host;
	private String url;
	private Connection connection = null;
	
	private final String params = "serverTimezone=UTC"; // https://stackoverflow.com/questions/26515700/mysql-jdbc-driver-5-1-33-time-zone-issue
	
	public Conexion() {
		
		String[] datos = getConnectionInfo();
		
		connection = null;
		host = datos[0];
		bd = datos[1];
		username = datos[2];
		password = datos[3];
		url = "jdbc:mysql://"+host+":3306/"+bd+"?"+params;
	}
	
	// lee los datos de conexion a la base de datos del archivo /resources/datosBBDD.txt
	public String[] getConnectionInfo() {

		String filePath = "src/main/java/resources/datosBBDD.txt";
		FileReader fileReader = null;
		BufferedReader buffer = null;
		String[] datos = new String[4];
		String linea = "";
		int count = 0;
		
		// carga el archivo de datos en un buffer
		try {
			fileReader = new FileReader(filePath);
			buffer = new BufferedReader(fileReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		  
		// recorre el buffer leyendo de cada linea del archivo el substring
		// necesario y lo guarda en una entrada del array
		try {
			while ((linea = buffer.readLine()) != null) {
				datos[count] = linea.substring(linea.indexOf(":") + 2);
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return datos;
		
	}
	
	protected Connection conectar(){
		try { connection = DriverManager.getConnection(url, username, password); } 
		catch (SQLException e) { throw new IllegalStateException("Cannot connect the database!", e); }
		return connection;
	}

	protected void desconectar(){
		if (connection != null)
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
	}

}